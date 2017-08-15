package Servletler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.KisiController;
import Entity.Kisi;
import Model.KisiModel;

/**
 * Servlet implementation class KisiKayitServlet
 */
@WebServlet("/KisiKayitServlet")
public class KisiKayitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KisiKayitServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Kisi k = new Kisi();
		k.setTc(request.getParameter("tc"));
		k.setAd(request.getParameter("ad"));
		k.setSoyad(request.getParameter("soyad"));
		k.setEmail(request.getParameter("email"));
		KisiController kc = new KisiController();
		int kisiId = kc.record(k);
		if (kisiId != 0) {
			response.sendRedirect("TelefonServlet?ID=" + kisiId);
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
