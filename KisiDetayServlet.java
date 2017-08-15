package Servletler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.AdresBilgiController;
import Controller.CommentController;
import Controller.KisiController;
import Entity.AdresBilgi;
import Entity.Comment;
import Entity.Kisi;
import Entity.TelBilgi;

/**
 * Servlet implementation class KisiDetayServlet
 */
@WebServlet("/KisiDetayServlet")
public class KisiDetayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KisiDetayServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String comment = request.getParameter("comment");
		String pId = request.getParameter("id");

		Kisi k = new Kisi();
		PrintWriter out = response.getWriter();
		KisiController kc = new KisiController();
		AdresBilgiController abc = new AdresBilgiController();

		if (pId != null) {
			int id = Integer.parseInt(pId);
			k = kc.getKisiById(id);

			out.println(
					"  <html lang=\"tr\"><head>                                                                                               ");
			out.println("	\r\n" + "<LINK REL=\"StyleSheet\" HREF=\""
					+ request.getContextPath()
					+ "/util/CSS/bootstrap.css\" TYPE=\"text/css\">                                                                                     ");
			out.println(
					"    <title>KisiListeServlet</title>"
					+ ""
					+ ""
					+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />"
					+ "</head><body style='background-color:#FFF'>                     ");

			out.println("<div class=\"row col-md-12\" > ");
			out.println(
					"<table class=\"table table-hover  \" border='2' style='background-color:#9797fc; color:#000;'  >");

			out.println("<tr   style='background-color:#083868; color:#FFF;' >");
			out.println("<td style='font-weight:bold; font-size:20px;' width='150px'>");
			out.println("Adres Tipi");
			out.println("</td>");
			out.println("<td style='font-weight:bold; font-size:20px;' width='150px'>");
			out.println("Mahalle");
			out.println("</td>");
			out.println("<td style='font-weight:bold; font-size:20px;' width='150px'>");
			out.println("Cadde");
			out.println("</td>");
			out.println("<td style='font-weight:bold; font-size:20px;' width='150px'>");
			out.println("Sokak");
			out.println("</td>");
			out.println("<td style='font-weight:bold; font-size:20px;' width='150px'>");
			out.println("Kapi No");
			out.println("</td>");
			out.println("<td style='font-weight:bold; font-size:20px;' width='150px'>");
			out.println("Il");
			out.println("</td>");
			out.println("</tr>");
			for (int i = 0; i < k.getAdres().size(); i++) {
				AdresBilgi ab = k.getAdres().get(i);

				out.println("<tr>");
				out.println("<td>");
				out.print(ab.getAdresTip());
				out.println("</td>");
				out.println("<td>");
				out.print(ab.getMahalle());
				out.println("</td>");
				out.println("<td>");
				out.print(ab.getCadde());
				out.println("</td>");
				out.println("<td>");
				out.print(ab.getSokak());
				out.println("</td>");
				out.println("<td>");
				out.print(ab.getNo());
				out.println("</td>");
				out.println("<td>");
				out.print(ab.getIl());
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");

			out.println("<div class=\"row col-md-6 col-md-offset-3 \" > ");

			out.println(
					"<table class=\"table table-hover  \" border='2' style='background-color:#9797fc; color:#000;'  >");

			out.println("<tr style='background-color:#083868; color:#FFF;' >");
			out.println("<td style='font-weight:bold; font-size:20px;' width='150px'>");
			out.println("Telefon Tipi");
			out.println("</td>");
			out.println("<td style='font-weight:bold; font-size:20px;' width='150px'>");
			out.println("Telefon Numarasi");
			out.println("</td>");
			out.println("</tr>");

			for (int i = 0; i < k.getTelefon().size(); i++) {
				TelBilgi tb = k.getTelefon().get(i);

				out.println("<tr>");
				out.println("<td>");
				out.print(tb.getTelTip() + "\t");
				out.println("</td>");
				out.println("<td>");
				out.print(tb.getNumara() + "\t");
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</div>");

			out.println("<div class=\"row col-md-6 col-md-offset-3 \" > ");

			out.println(
					"<form class=\"form-horizontal\" action=\"/WicWeb1/CommentKayitServlet\" onsubmit=\"return kontrol()\" method=\"post\">  ");
			out.println(
					"<table class=\"table table-hover  \" border='2' style='background-color:#9797fc; color:#000;'  >");
			CommentController cc = new CommentController();

			ArrayList<Comment> commentList = cc.getAllCommentsByKisiId(id);

			out.println("<tr style='background-color:#083868; color:#FFF;' >");
			out.println("<td style='font-weight:bold; font-size:20px;' width='150px' colspan='3' >");
			out.println("Yorum");
			out.println("</td>");
			out.println("</tr>");

			for (int i = 0; i < commentList.size(); i++) {
				out.println("<tr>");
				out.println("<td>");
				out.println(commentList.get(i).getComment());
				out.println("</td>");
				out.println("</tr>");
			}

			out.println("</table>");
			out.println("<input type='hidden' value='" + pId + "' name='id'/>  ");
			out.println(
					"<textarea name='comment' class='form-control' style='height:100px; border-style:solid; border-color:#000;' ></textarea>");
			out.println("<button type=\"submit\" class=\"btn btn-Primary\">Kaydet</button>");

			out.println("</form>");

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
