package Servletler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.AdresBilgiController;
import Controller.AdresController;
import Controller.KisiController;
import Controller.TelefonController;
import Entity.AdresBilgi;
import Model.AdresBilgiModel;

/**
 * Servlet implementation class AdresKayitServlet
 */
@WebServlet("/AdresKayitServlet")
public class AdresKayitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdresKayitServlet() {
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
		int kisiId=Integer.parseInt(request.getParameter("ID"));
		PrintWriter out = response.getWriter();
		AdresBilgi ab = new AdresBilgi();
		ab.setAdresTip(request.getParameter("adresTip"));
		ab.setMahalle(request.getParameter("mahalle"));
		ab.setCadde(request.getParameter("cadde"));
		ab.setSokak(request.getParameter("sokak"));
		ab.setNo(request.getParameter("kapiNo"));
		ab.setIl(request.getParameter("il"));
		AdresBilgiController abc = new AdresBilgiController();
		int adresId=abc.record(ab);
		AdresController ac=new AdresController();
		ac.record(adresId, kisiId);
		response.sendRedirect("KisiServlet");
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
