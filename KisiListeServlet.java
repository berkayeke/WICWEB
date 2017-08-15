package Servletler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.KisiController;
import Entity.Kisi;

/**
 * Servlet implementation class KisiListeServlet
 */
@WebServlet("/KisiListeServlet")
public class KisiListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KisiListeServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		KisiController kc = new KisiController();
		ArrayList<Kisi> kisiler = kc.getAllKisiler();

		out.println(
				"  <html lang=\"en\"><head>                                                                                               ");
		out.println("    <meta charset=\"utf-8\">    " + "	\r\n" + "<LINK REL=\"StyleSheet\" HREF=\""
				+ request.getContextPath()
				+ "/util/CSS/bootstrap.css\" TYPE=\"text/css\">                                                                                     ");
		out.println(
				"    <title>KisiListeServlet</title></head><body style='background-color:#FFF'>                     ");
		
		out.println("<div class=\"row col-md-8 col-md-offset-2 \" > ");
		out.println("<table class=\"table table-hover  \" border='2' style='background-color:#9797fc; color:#000;'  >");
		
		out.println("<tr   style='background-color:#083868; color:#FFF;' >");
		
		out.println("<td style='font-weight:bold; font-size:20px;' width='150px'>");
		out.println("TC No");
		out.println("</td>");
		out.println("<td style='font-weight:bold; font-size:20px;' width='200px'>");
		out.println("Ad");
		out.println("</td>");
		out.println("<td style='font-weight:bold; font-size:20px;' width='200px'>");
		out.println("Soyad");
		out.println("</td>");
		out.println("<td style='font-weight:bold; font-size:20px;' width='300px'>");
		out.println("Email");
		out.println("</td>");
		out.println("<td style='font-weight:bold; font-size:20px;' width='50px'>");
		out.println("Detaylar");
		out.println("</td>");
		
	
		out.println("</tr>");
		for (int i = 0; i < kisiler.size(); i++) {
			Kisi k = kisiler.get(i);

			out.println("<tr>");

			out.println("<td style='font-weight:bold; font-size:14px;'>");
			out.print(k.getTc() + "\t");
			out.println("</td>");
			out.println("<td>");
			out.print(k.getAd() + "\t");
			out.println("</td>");
			out.println("<td>");
			out.print(k.getSoyad() + "\t");
			out.println("</td>");
			out.println("<td>");
			out.println(k.getEmail());
			out.println("</td>");
			out.println("<td style='font-weight:bold; font-size:15px; text-align:center;'>");
			out.println("<a href='KisiDetayServlet?id=" + k.getKisiID() + "'>Detay</a>");
			out.println("</td>");
			out.println("</tr>");

		}
		out.println("</table>");
		out.println("</div>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
