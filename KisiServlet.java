package Servletler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Kisi;
import Model.KisiModel;

/**
 * Servlet implementation class KisiServlet
 */
@WebServlet("/KisiServlet")
public class KisiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KisiServlet() {
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

		out.println("  <html lang=\"en\"><head>                                                                                               ");
		out.println("    <meta charset=\"utf-8\">    " + "	\r\n" + "<LINK REL=\"StyleSheet\" HREF=\""
				+ request.getContextPath()
				+ "/util/CSS/bootstrap.css\" TYPE=\"text/css\">                                                                                     ");
		out.println("    <title>WIC</title>                                                                                                   ");
		out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">                                             ");
		out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">                                                            ");
		out.println("<script>                                                                                                            ");
		out.println("	function kontrol(){                                                                                                 ");
		out.println("                                                                                                               ");
		out.println("		 if ( document.getElementById(\"tc\").value.length !=11){                                                     ");
		out.println("			alert(\"Tc Hatali...!!!\");                                                           ");
		out.println("				return false;                                                                            ");
		out.println("                                                                                                            ");
		out.println("			}                                                                                                        ");
		out.println("			 if ( document.getElementById(\"ad\").value.length <3)                                                    ");
		out.println("			{                                                                                                       ");
		out.println("				alert(\"Ad 4 karakterden az olamaz\");                                                                ");
		out.println("				return false;                                                                                           ");
		out.println("			}                                                                                                          ");
		out.println("		  if (  document.getElementById(\"soyad\").value.length <2)        											  ");
		out.println("			{                                                                                          		            ");
		out.println("				alert(\"Soyad 2 karakterden az olamaz\");                                                              ");
		out.println("				return false;                                                                                           ");
		out.println("			}                                                                                                           ");
		out.println("			if(document.getElementById(\"email\").value.length==0||                                                    ");
		out.println("             document.getElementById(\"email\").value.indexOf(\"@\")<1 ||                                              ");
		out.println("             document.getElementById(\"email\").value.lastIndexOf(\".\")< document.getElementById(\"email\").value.indexOf(\"@\")+2 ||");
		out.println("             document.getElementById(\"email\").value.indexOf(\"@\")+2>=document.getElementById(\"email\").value.length   ");
		out.println("              )                                                                                                          ");
		out.println("			                                                                                       	                    ");
		out.println("			{                                                                                             			      ");
		out.println("				alert(\"Gecerli email adresi girin\");                                                          	      ");
		out.println("				return false;                                                                                             ");
		out.println("			}                                                                                                             ");
		out.println("			return true;	                                                                                              ");
		out.println(				"	}                                                                                                                     ");
		out.println("</script>                                                                                                                ");
		out.println("    </head>                                                                                                              ");
		out.println("  <body>                                                                                                                 ");
		out.println("    <div class=\"navbar navbar-default navbar-fixed-top\">                                                               ");
		out.println("      <div class=\"container\">                                                                                          ");
		out.println("<img src='http://sigortammax.com/wp-content/uploads/2015/08/Anadolu-Sigorta.png'   style='width:100px; height:auto;'>  ");
		out.println("        <div class=\"navbar-header\">                                                                                    ");
		out.println("          <a href=\"KisiServlet\" class=\"navbar-brand\">Anasayfa</a>                                                    ");
		out.println("          <button class=\"navbar-toggle\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar-main\">         ");
		out.println("            <span class=\"icon-bar\"></span>                                                                             ");
		out.println("            <span class=\"icon-bar\"></span>                                                                             ");
		out.println("            <span class=\"icon-bar\"></span>                                                                             ");
		out.println("          </button>                                                                                                      ");
		out.println("        </div>                                                                                                           ");
		out.println("          <ul class=\"nav navbar-nav\">                                                                                  ");
		out.println("		   <li>                                                                                                           ");
		out.println("              <a href=\"KisiServlet\">Kisi Kaydi</a>                                                                     ");
		out.println("            </li>                                                                                                        ");
		out.println("            <li>                                                                                                         ");
		out.println("              <a href=\"AdresServlet\">Adres Kaydi</a>                                                                   ");
		out.println("            </li>                                                                                                        ");
		out.println("            <li>                                                                                                         ");
		out.println("              <a href=\"TelefonServlet\">Telefon Kaydi</a>                                                               ");
		out.println("            </li>                                                                                                        ");
		out.println("          </ul>                                                                                                          ");
		out.println("          <ul class=\"nav navbar-nav navbar-right\">                                                                     ");
		out.println("            <li><a href=\"KisiListeServlet\" target=\"_blank\">Admin</a></li>                                            ");
		out.println("          </ul>                                                                                                          ");
		out.println("        </div>                                                                                                           ");
		out.println("      </div>                                                                                                             ");
		out.println("    </div>                                                                                                               ");
		out.println("    <div class=\"container\">                                                                                            ");
		out.println("    <br>                                                                                                                 ");
		out.println("      <!-- Forms                                                                                                         ");
		out.println("      ================================================== -->                                                             ");
		out.println("      <div class=\"bs-docs-section\">                                                                                    ");
		out.println("        <div class=\"row\">                                                                                              ");
		out.println("          <div class=\"col-lg-12\">                                                                                      ");
		out.println("            <div class=\"page-header\">                                                                                  ");
		out.println("              <h1 id=\"forms\">Kisi Kayit Formu</h1>                                                                     ");
		out.println("            </div>                                                                                                       ");
		out.println("          </div>                                                                                                         ");
		out.println("        </div>                                                                                                           ");
		out.println("        <div class=\"row\">                                                                                              ");
		out.println("          <div class=\"col-lg-8\">                                                                                       ");
		out.println("            <div class=\"well bs-component\">                                                                            ");
		out.println("              <form class=\"form-horizontal\" action=\"/WicWeb1/KisiKayitServlet\" onsubmit=\"return kontrol()\" method=\"get\">  ");
		out.println("                <fieldset>                                                                                               ");
		out.println("				  <div class=\"form-group\">                                                                              ");
		out.println("                    <label class=\"col-lg-2 control-label\" for=\"focusedInput\">Tc</label>                              ");
		out.println("					<div class=\"col-lg-10\">                                                                             ");
		out.println("                    <input class=\"form-control\" maxlength=\"11\" id=\"tc\" type=\"text\"placeholder=\"TC Giriniz\" name=\"tc\" > ");
		out.println("					</div>                                                                                                ");
		out.println("                    </div>                                                                                               ");
		out.println("					<div class=\"form-group\">                                                                            ");
		out.println("                    <label class=\"col-lg-2 control-label\" for=\"focusedInput\">Ad</label>                              ");
		out.println("					<div class=\"col-lg-10\">                                                                             ");
		out.println("                    <input class=\"form-control\" id=\"ad\" type=\"text\"placeholder=\"Ad Giriniz\" name=\"ad\">         ");
		out.println("					</div>                                                                                                ");
		out.println("                    </div>                                                                                               ");
		out.println("					<div class=\"form-group\">                                                                            ");
		out.println("                    <label class=\"col-lg-2 control-label\" for=\"focusedInput\">Soyad</label>                           ");
		out.println("					<div class=\"col-lg-10\">                                                                             ");
		out.println("                    <input class=\"form-control\" id=\"soyad\" type=\"text\"placeholder=\"Soyad Giriniz\" name=\"soyad\"> ");
		out.println("					</div>                                                                                                ");
		out.println("                    </div>                                                                                               ");
		out.println("                  <div class=\"form-group\">                                                                             ");
		out.println("                    <label for=\"inputEmail\" class=\"col-lg-2 control-label\">Email</label>                             ");
		out.println("                    <div class=\"col-lg-10\">                                                                            ");
		out.println("                      <input type=\"text\" class=\"form-control\" id=\"email\" placeholder=\"Email\" name=\"email\">     ");
		out.println("                    </div>                                                                                               ");
		out.println("					 </div>                                                                                               ");
		out.println("                </fieldset>                                                                                              ");
		out.println("					  <div class=\"form-group\">                                                                          ");
		out.println("                      <div class=\"col-lg-10 col-lg-offset-7\">                                                          ");
		out.println("                       <button type=\"reset\" class=\"btn btn-default\">Cancel</button>                                  ");
		out.println("                       <button type=\"submit\" class=\"btn btn-Primary\">Submit</button>                                 ");
		out.println("                      </div>                                                                                             ");
		out.println("              </form>                                                                                                    ");
		out.println("			  </div>                                                                                                      ");
		out.println("      <div id=\"source-modal\" class=\"modal fade\">                                                                     ");
		out.println("        <div class=\"modal-dialog modal-lg\">                                                                            ");
		out.println("          <div class=\"modal-content\">                                                                                  ");
		out.println("            <div class=\"modal-header\">                                                                                 ");
		out.println("              <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\"></button>             ");
		out.println("              <h4 class=\"modal-title\">Source Code</h4>                                                                 ");
		out.println("            </div>                                                                                                       ");
		out.println("            <div class=\"modal-body\">                                                                                   ");
		out.println("              <pre></pre>                                                                                                ");
		out.println("            </div>                                                                                                       ");
		out.println("          </div>                                                                                                         ");
		out.println("        </div>                                                                                                           ");
		out.println("      </div>                                                                                                             ");
		out.println("      <footer>                                                                                                           ");
		out.println("      </footer>                                                                                                          ");
		out.println("</div>																												  ");
		out.println("	 </body></html>																									  ");
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
