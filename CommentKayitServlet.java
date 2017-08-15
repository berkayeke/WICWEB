package Servletler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.CommentController;
import Entity.AdresBilgi;
import Entity.Comment;

/**
 * Servlet implementation class CommentKayitServlet
 */
@WebServlet("/CommentKayitServlet")
public class CommentKayitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentKayitServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doget");
		String comment = request.getParameter("comment");
		String pId = request.getParameter("id");
		
		System.out.println(comment);
		PrintWriter out = response.getWriter();
		
		Comment c = new Comment();
		if (comment != null && pId != null) {

			
			c.setKisiId(Integer.parseInt(pId));
			c.setComment(comment);
			
			CommentController cc=new CommentController();
			cc.record(c);

			response.sendRedirect("KisiDetayServlet?id=" + pId);

		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
