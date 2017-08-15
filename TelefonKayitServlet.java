package Servletler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TelBilgiController;
import Controller.TelefonController;
import Entity.TelBilgi;

/**
 * Servlet implementation class TelefonKayitServlet
 */
@WebServlet("/TelefonKayitServlet")
public class TelefonKayitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TelefonKayitServlet() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		TelBilgi tb = new TelBilgi();
		tb.setTelTip(request.getParameter("telTip"));
		tb.setNumara(request.getParameter("numara") + request.getParameter("telNo"));
		TelBilgiController tbc = new TelBilgiController();
		int telId = tbc.record(tb);
		int kisiId = Integer.parseInt(request.getParameter("ID")) ;
		TelefonController tc=new TelefonController();
		tc.record(telId,kisiId);
		response.sendRedirect("AdresServlet?ID=" + kisiId);
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
