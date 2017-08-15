package Servletler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Controller.SehirlerController;
import Entity.Sehir;

/**
 * Servlet implementation class AdresServlet
 */
@WebServlet("/AdresServlet")
public class AdresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdresServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		Locale.setDefault(new Locale("tr", "TR"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String kisiId = request.getParameter("ID");
		out.println(" <html ><head>                                                                                                       ");
		out.println("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> <LINK REL=\"StyleSheet\" HREF=\""
						+ request.getContextPath()
						+ "/util/CSS/bootstrap.css\" TYPE=\"text/css\">                                                                       ");
		out.println("    <title>WIC</title>                                                                                               ");
		out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">                                         ");
		out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">                                                        ");
		out.println("    <link rel=\"stylesheet\" href=\"./bootstrap.css\" media=\"screen\">                                              ");
		out.println("    <link rel=\"stylesheet\" href=\"../assets/css/custom.min.css\">                                                  ");
		out.println("<script>                                                                                                             ");
		out.println("	function kontrol(){                                                                                               ");
		out.println("		 if ( document.getElementById(\"mahalle\").value.length ==0){                                                 ");
		out.println("			alert(\"Mahalle Adi Bos Birakilamaz...!!!\");                                                             ");
		out.println("				return false;                                                                                         ");
		out.println("			}                                                                                                         ");
		out.println("			 if ( document.getElementById(\"kapino\").value.length ==0)                                               ");
		out.println("			{                                                                                                         ");
		out.println("				alert(\"Kapi No Bos Birakilamaz...!!!\");                                                             ");
		out.println("				return false;                                                                                         ");
		out.println("			}                                                                                                         ");
		out.println("			 if ( document.getElementById(\"il\").value.length ==0)                                               ");
		out.println("			{                                                                                                         ");
		out.println("				alert(\"Il Adi Bos Birakilamaz...!!!\");                                                             ");
		out.println("				return false;                                                                                         ");
		out.println("			}                                                                                                         ");
		out.println("			return true;	                                                                                          ");
		out.println("	}                                                                                                                 ");
		out.println("</script>                                                                                                            ");
		out.println("    </head>                                                                                                          ");
		out.println("  <body>                                                                                                             ");
		out.println("    <div class=\"navbar navbar-default navbar-fixed-top\">                                                           ");
		out.println("      <div class=\"container\">                                                                                      ");
		out.println("<img src='http://sigortammax.com/wp-content/uploads/2015/08/Anadolu-Sigorta.png'   style='width:100px; height:auto;'>  ");
		out.println("        <div class=\"navbar-header\">                                                                                ");
		out.println("          <a href=\"KisiServlet\" class=\"navbar-brand\">Anasayfa</a>                                                ");
		out.println("          <button class=\"navbar-toggle\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar-main\">     ");
		out.println("            <span class=\"icon-bar\"></span>                                                                         ");
		out.println("            <span class=\"icon-bar\"></span>                                                                         ");
		out.println("            <span class=\"icon-bar\"></span>                                                                         ");
		out.println("          </button>    </div>                                                                                               ");
		out.println("          <ul class=\"nav navbar-nav\">                                                                              ");
		out.println("		   <li>                                                                                                       ");
		out.println("              <a href=\"KisiServlet\">Kisi Kaydi</a>                                                                 ");
		out.println("            </li>                                                                                                    ");
		out.println("            <li>                                                                                                     ");
		out.println("              <a href=\"AdresServlet\">Adres Kaydi</a>                                                               ");
		out.println("            </li>                                                                                                    ");
		out.println("            <li>                                                                                                     ");
		out.println("              <a href=\"TelefonServlet\">Telefon Kaydi</a>                                                           ");
		out.println("            </li>   </ul>                                                                                                  ");
		out.println("          <ul class=\"nav navbar-nav navbar-right\">                                                                 ");
		out.println("            <li><a href=\"KisiListeServlet\" target=\"_blank\">Admin</a></li>                                        ");
		out.println("          </ul>     </div>  </div>  </div>                                                                                                  ");
		out.println("    <div class=\"container\">                                                                                        ");
		out.println("    <br>          <!-- Forms      ================================================== -->         ");
		out.println("      <div class=\"bs-docs-section\">                                                                                ");
		out.println("        <div class=\"row\">                                                                                          ");
		out.println("          <div class=\"col-lg-12\">                                                                                  ");
		out.println("            <div class=\"page-header\">                                                                              ");
		out.println("              <h1 id=\"forms\">Adres Kaydi</h1>                                                                      ");
		out.println("            </div>   </div>   </div>                                                                                               ");
		out.println("        <div class=\"row\">                                                                                          ");
		out.println("          <div class=\"col-lg-8\">                                                                                   ");
		out.println("            <div class=\"well bs-component\">                                                                        ");
		out.println("              <form class=\"form-horizontal\" action=\"/WicWeb1/AdresKayitServlet\"  onsubmit=\"return kontrol()\" method=\"get\">                                                                     ");
		out.println("                <fieldset>                                                                                           ");
		out.println("					<div class=\"form-group\">                                                                        ");
		out.println("                    <label for=\"select\" class=\"col-lg-2 control-label\">Adres Tipi</label>                        ");
		out.println("                    <div class=\"col-lg-10\">                                                                        ");
		out.println("                    <select class=\"form-control\" id=\"adresTip\" name=\"adresTip\">                                ");
		out.println("<option>Lütfen Secim Yapiniz!</option>	<option>Ev</option>	<option>Is</option>	 <option>Yazlik</option>");
		out.println("                   </select>                                                                                         ");
		out.println("					</div>                                                                                            ");
		out.println("                </fieldset>                                                                                          ");
		out.println("					<div class=\"form-group\">                                                                        ");
		out.println("                    <label class=\"col-lg-2 control-label\" for=\"focusedInput\">Mahalle</label>                     ");
		out.println("					<div class=\"col-lg-10\">                                                                         ");
		out.println("                    <input class=\"form-control\" id=\"mahalle\" type=\"text\"placeholder=\"Mahalle Giriniz\" name=\"mahalle\">       ");
		out.println("					</div>	</div>                                                                                            ");
		out.println("					<div class=\"form-group\">                                                                        ");
		out.println("                    <label class=\"col-lg-2 control-label\" for=\"focusedInput\">Cadde</label>                       ");
		out.println("					<div class=\"col-lg-10\">                                                                         ");
		out.println("                    <input class=\"form-control\" id=\"cadde\" type=\"text\"placeholder=\"Cadde Giriniz\" name=\"cadde\">           ");
		out.println("					</div>     </div>                                                                                       ");
		out.println("					<div class=\"form-group\">                                                                        ");
		out.println("                    <label class=\"col-lg-2 control-label\" for=\"focusedInput\">Sokak</label>                       ");
		out.println("					<div class=\"col-lg-10\">                                                                         ");
		out.println("                    <input class=\"form-control\" id=\"sokak\" type=\"text\"placeholder=\"Sokak Giriniz\" name=\"sokak\">           ");
		out.println("					</div>    </div>                                                                                        ");
		out.println("					<div class=\"form-group\">                                                                        ");
		out.println("                    <label class=\"col-lg-2 control-label\" for=\"focusedInput\">Kapi No</label>                     ");
		out.println("					<div class=\"col-lg-10\">                                                                         ");
		out.println("                    <input class=\"form-control\" id=\"kapino\" type=\"text\"placeholder=\"Kapi No Giriniz\" name=\"kapiNo\">        ");
		out.println("					</div>  </div>                                                                                          ");
		out.println("                                                                                                               ");
		out.println("					<div class=\"form-group\">                                                                        ");
		out.println("                    <label for=\"select\" class=\"col-lg-2 control-label\">Il</label>                                ");
		out.println("                    <div class=\"col-lg-10\">                                                                        ");
		SehirlerController sc = new SehirlerController();
		ArrayList<Sehir> sehiradi = sc.getAllSehir();
		out.println("<select name=\"il\" class=\"form-control\">");
		out.println("<option>Lütfen Secim Yapiniz!</option>");
		for (int i = 0; i < sehiradi.size(); i++) {
			out.println("<option value='" + sehiradi.get(i).getIlID() + "'>" + sehiradi.get(i).getIl() + "</option>");
		}
		out.println("</select>");
		out.println("					</div>                                                                                            ");
		out.println("                </fieldset>                                                                                          ");
		out.println("					  <div class=\"form-group\">                                                                      ");
		out.println("                      <div class=\"col-lg-10 col-lg-offset-7\">                                                      ");
		out.println("                       <button type=\"reset\" class=\"btn btn-default\">Cancel</button>                              ");
		out.println("                      <button type=\"submit\" class=\"btn btn-primary\">Submit</button>                              ");
		out.println("                      </div>    " + "<input type='hidden' value='" + kisiId + "' name='ID'/>                                						      ");
		out.println("              </form>                                                                                                ");
		out.println("			  </div>                                                                                                  ");
		out.println("      <div id=\"source-modal\" class=\"modal fade\">                                                                 ");
		out.println("        <div class=\"modal-dialog modal-lg\">                                                                        ");
		out.println("          <div class=\"modal-content\">                                                                              ");
		out.println("            <div class=\"modal-header\">                                                                             ");
		out.println("              <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\"></button>         ");
		out.println("              <h4 class=\"modal-title\">Source Code</h4>                                                             ");
		out.println("            </div>                                                                                                   ");
		out.println("            <div class=\"modal-body\">                                                                               ");
		out.println("              <pre></pre>                                                                                            ");
		out.println("            </div>    </div>     </div>   </div>                                                                                                ");
		out.println("      <footer>       </footer>                                                                                                     ");
		out.println("    </div>                                                                                                           ");
		out.println("</body></html>  ");
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
