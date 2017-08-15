package Servletler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TelefonServlet
 */
@WebServlet("/TelefonServlet")
public class TelefonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TelefonServlet() {
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
		String kisiId = request.getParameter("ID");
		PrintWriter out = response.getWriter();
		out.println(" <html lang=\"en\"><head>                                                                                            ");
		out.println("    <meta charset=\"utf-8\">    " + "	\r\n" + "<LINK REL=\"StyleSheet\" HREF=\""
				+ request.getContextPath()
				+ "/util/CSS/bootstrap.css\" TYPE=\"text/css\">                                                                                     ");
		out.println("    <title>WIC</title>                                                                                               ");
		out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">                                         ");
		out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">                                                        ");
		out.println("    <link rel=\"stylesheet\" href=\"./bootstrap.css\" media=\"screen\">                                              ");
		out.println("    <link rel=\"stylesheet\" href=\"../assets/css/custom.min.css\">                                                  ");
		out.println("<script>                                                                                                                                       ");
		out.println("	function kontrol(){                                                                                                                         ");
		out.println("		 if ( document.getElementById(\"numara1\").value.length ==0 || document.getElementById(\"numara1\").value.length <7){                   ");
		out.println("			alert(\"Eksik Bir Telefon Numarasi Tusladiniz...!!!\");                                                                             ");
		out.println("				return false;                                                                                                                   ");
		out.println("			}                                                                                                                                   ");
		out.println("			return true;	                                                                                                                    ");
		out.println("	}                                                                                                                                           ");
		out.println("</script>                                                                                                                                      ");
		out.println("    </head>                                                                                                          ");
		out.println("  <body>                                                                                                             ");
		out.println("    <div class=\"navbar navbar-default navbar-fixed-top\">                                                           ");
		out.println("      <div class=\"container\">                                                                                      ");
		out.println("<img src='C:\\Users\\Samsung\\Desktop\\Anadolu-Sigorta.png'   style='width:100px height:auto;'>   ");
		out.println("        <div class=\"navbar-header\">                                                                                ");
		out.println("          <a href=\"KisiServlet\" class=\"navbar-brand\">Anasayfa</a>                                               ");
		out.println("          <button class=\"navbar-toggle\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar-main\">     ");
		out.println("            <span class=\"icon-bar\"></span>                                                                         ");
		out.println("            <span class=\"icon-bar\"></span>                                                                         ");
		out.println("            <span class=\"icon-bar\"></span>                                                                         ");
		out.println("          </button>                                                                                                  ");
		out.println("        </div>                                                                                                       ");
		out.println("          <ul class=\"nav navbar-nav\">                                                                              ");
		out.println("		   <li>                                                                                                           ");
		out.println("              <a href=\"KisiServlet\">Kisi Kaydi</a>                                                                       ");
		out.println("            </li>                                                                                                        ");
		out.println("            <li>                                                                                                         ");
		out.println("              <a href=\"AdresServlet\">Adres Kaydi</a>                                                                     ");
		out.println("            </li>                                                                                                        ");
		out.println("            <li>                                                                                                         ");
		out.println("              <a href=\"TelefonServlet\">Telefon Kaydi</a>                                                                 ");
		out.println("            </li>                                                                                                        ");
		out.println("          </ul>                                                                                                      ");
		out.println("          <ul class=\"nav navbar-nav navbar-right\">                                                                 ");
		out.println("            <li><a href=\"KisiListeServlet\" target=\"_blank\">Admin</a></li>                                                       ");
		out.println("          </ul>                                                                                                      ");
		out.println("        </div>                                                                                                       ");
		out.println("      </div>                                                                                                         ");
		out.println("    </div>                                                                                                           ");
		out.println("    <div class=\"container\">                                                                                        ");
		out.println("    <br>                                                                                                             ");
		out.println("      <!-- Forms                                                                                                     ");
		out.println("      ================================================== -->                                                         ");
		out.println("      <div class=\"bs-docs-section\">                                                                                ");
		out.println("        <div class=\"row\">                                                                                          ");
		out.println("          <div class=\"col-lg-12\">                                                                                  ");
		out.println("            <div class=\"page-header\">                                                                              ");
		out.println("              <h1 id=\"forms\">Telefon Kaydi</h1>                                                                    ");
		out.println("            </div>                                                                                                   ");
		out.println("          </div>                                                                                                     ");
		out.println("        </div>                                                                                                       ");
		out.println("        <div class=\"row\">                                                                                          ");
		out.println("          <div class=\"col-lg-8\">                                                                                   ");
		out.println("            <div class=\"well bs-component\">                                                                        ");
		out.println("              <form class=\"form-horizontal\"  action=\"/WicWeb1/TelefonKayitServlet\"  onsubmit=\"return kontrol()\"  method=\"get\">                                                                         ");
		out.println("                <fieldset>                                                                                           ");
		out.println("					<div class=\"form-group\">                                                                        ");
		out.println("					<div class=\"col-lg-7\">                                                                          ");
		out.println("                  <input type=\"hidden\"  value=\"?\"																  ");
		out.println("					</div>                                                                                            ");
		out.println("					</div>                                                                                            ");
		out.println("					</br>                                                                                             ");
		out.println("					<div class=\"form-group\">                                                                        ");
		out.println("                    <label for=\"select\" class=\"col-lg-2 control-label\" for=\"focusedInput\">Telefon Tipi</label> ");
		out.println("                    <div class=\"col-lg-10\">                                                                         ");
		out.println("                    <select class=\"form-control\" id=\"telTip\" name=\"telTip\">                                    ");
		out.println("	<option>Lütfen Secim Yapiniz!</option>");
		out.println("                   <option>Ev</option>                                                                        		  ");
		out.println("				   <option>Is</option>                                                                    	          ");
		out.println("                   <option>Cep</option>                                                                              ");
		out.println("                   </select>                                                                                         ");
		out.println("					</div>                                                                                            ");
		out.println("                </fieldset>                                                                                          ");
		out.println("				 <div class=\"form-group\">                                                                           ");
		out.println("                    <label class=\"col-lg-2 control-label\" for=\"focusedInput\">Telefon Numarasi</label>                      ");
		out.println("					<div class=\"col-lg-5\">                                                                          ");
		out.println("                    <select class=\"form-control\" id=\"numara\" name=\"numara\">                                                    ");
		out.println("<option>Lütfen Secim Yapiniz!</option>");
		// EV VE ÝÞ TELEFONU NUMARALARI
		out.println("	<option>322</option>	<option>318</option>	<option>416</option>	<option>288</option>");
		out.println("	<option>272</option>    <option>386</option>	<option>472</option>	<option>348</option>");
		out.println("	<option>382</option>	<option>344</option>	<option>358</option>	<option>262</option>");
		out.println("	<option>312</option>    <option>332</option>    <option>242</option>	<option>274</option>");
		out.println("	<option>478</option>	<option>422</option>    <option>466</option>	<option>236</option>");
		out.println("	<option>256</option>	<option>482</option>    <option>266</option>	<option>252</option>");
		out.println("	<option>378</option>	<option>436</option>    <option>488</option>	<option>384</option>");
		out.println("	<option>458</option>	<option>388</option>    <option>228</option>	<option>452</option>");
		out.println("	<option>426</option>	<option>328</option>    <option>434</option>	<option>464</option>");
		out.println("	<option>374</option>	<option>264</option>    <option>248</option>	<option>362</option>");
		out.println("	<option>224</option>	<option>484</option>    <option>286</option>	<option>368</option>");
		out.println("	<option>376</option>	<option>346</option>	<option>364</option>    <option>414</option>");
		out.println("	<option>258</option>	<option>486</option>	<option>412</option>	<option>282</option>");
		out.println("	<option>380</option>	<option>284</option>	<option>356</option>	<option>424</option>");
		out.println("	<option>462</option>    <option>446</option>	<option>428</option>    <option>442</option>");
		out.println("	<option>276</option>    <option>222</option>	<option>432</option>    <option>342</option>");
		out.println("	<option>226</option>    <option>454</option>	<option>354</option>    <option>456</option>");
		out.println("	<option>372</option>    <option>438</option>    <option>326</option>	<option>476</option>");
		out.println("	<option>246</option>	<option>324</option>	<option>212</option>	<option>216</option>");
		out.println("	<option>232</option>	<option>370</option>	<option>338</option>	<option>474</option>");
		out.println("	<option>366</option>    <option>352</option>");
		// CEP TELEFONU NUMARALARI
		out.println("	<option>501</option>	<option>505</option>	<option>506</option>	<option>507</option>");
		out.println("	<option>551</option>	<option>552</option>	<option>553</option>	<option>554</option>");
		out.println("	<option>555</option>	<option>559</option>	<option>530</option>	<option>531</option>");
		out.println("	<option>532</option>	<option>533</option>	<option>534</option>	<option>535</option>");
		out.println("	<option>536</option>	<option>537</option>	<option>538</option>	<option>539</option>");
		out.println("	<option>561</option>	<option>540</option>	<option>541</option>	<option>542</option>");
		out.println("	<option>543</option>	<option>544</option>	<option>545</option>	<option>546</option>");
		out.println("	<option>547</option>	<option>548</option>	<option>549</option>");
		out.println("                   </select>                                                                                         ");
		out.println("				   </div>                                                                                             ");
		out.println("					<div class=\"col-lg-5\">                                                                          ");
		out.println("                    <input class=\"form-control\" maxlength=\"7\" id=\"numara1\" type=\"text\"placeholder=\"Telefon Numarasi Giriniz\"  name=\"telNo\"  ");
		out.println("					</div>                                                                                            ");
		out.println("                    </div>                                                                                           ");
		out.println("                </fieldset>                                                                                          ");
		out.println("					  <div class=\"form-group\">                                                                      ");
		out.println("                      <div class=\"col-lg-10 col-lg-offset-7\">                                                      ");
		out.println("                       <button type=\"reset\" class=\"btn btn-default\">Cancel</button>                              ");
		out.println("                      <button type=\"submit\" class=\"btn btn-primary\">Submit</button>                              ");
		out.println("                      </div>    " + "" + "<input type='hidden' value='" + kisiId +"' name='ID'/>                                             ");
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
		out.println("            </div>                                                                                                   ");
		out.println("          </div>                                                                                                     ");
		out.println("        </div>                                                                                                       ");
		out.println("      </div>                                                                                                         ");
		out.println("      <footer>                                                                                                       ");
		out.println("      </footer>                                                                                                      ");
		out.println("    </div>                                                                                                           ");
		out.println("</body></html>                                                                                                       ");
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
