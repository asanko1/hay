/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-01-07 05:51:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>H.A.Y::Login</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("<script src=\"js/index.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
if(session.getAttribute("email")!=null){
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <font color=\"blue\" size=\"5\">Hi! ");
      out.print(session.getAttribute("email"));
      out.write("</font>\r\n");
      out.write("\r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("        ");
 if(session.getAttribute("email")==null){
                             response.sendRedirect("index.jsp");
               }
      out.write("\r\n");
      out.write("\t<div class=\"header\">\r\n");
      out.write("\t\t<a href=\"#default\" class=\"logo\"><img src=\"images/logo.jpg\"\r\n");
      out.write("\t\t\twidth=\"90\" height=\"90\"></a>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"header-right\" >\r\n");
      out.write("\t\t\t<div class=\"dropdown\">\r\n");
      out.write("\t\t\t\t<button class=\"dropbtn\">Home</button>\r\n");
      out.write("\t\t\t\t<div class=\"dropdown-content\">\r\n");
      out.write("                                    <a href=\"Navigator?form_id=returnhome\">Dashboard</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("            ");
if(session.getAttribute("role").equals("Organizer")){
      out.write("\r\n");
      out.write("\t\t\t<div class=\"dropdown\">\r\n");
      out.write("\t\t\t\t<button class=\"dropbtn\">Profile</button>\r\n");
      out.write("\t\t\t\t<div class=\"dropdown-content\">\r\n");
      out.write("\t\t\t\t\t<a href=\"AddProfile.jsp\">Add New Profile</a>\r\n");
      out.write("                    <a href=\"SearchProfile.jsp\">Manage Profile</a>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"dropdown\">\r\n");
      out.write("\t\t\t\t<button class=\"dropbtn\">Organizer</button>\r\n");
      out.write("\t\t\t\t<div class=\"dropdown-content\">\r\n");
      out.write("\t\t\t\t\t<a href=\"AddOrganizer.jsp\">Add New Organizer</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">Manage Organizer</a> \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"dropdown\">\r\n");
      out.write("\t\t\t\t<button class=\"dropbtn\">Panelist</button>\r\n");
      out.write("\t\t\t\t<div class=\"dropdown-content\">\r\n");
      out.write("\t\t\t\t\t<a href=\"AddPanelist.jsp\">Add New Panelist</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">Manage Panelist</a> \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t<div class=\"dropdown\">\r\n");
      out.write("            \t\t\t\t<button class=\"dropbtn\"><img src=\"images/logout.png\" width=\"10\" height=\"15\"></button>\r\n");
      out.write("                            <div class=\"dropdown-content\">\r\n");
      out.write("                                <a href=\"Logout\">Logout</a>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("    <br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div style=\"padding-left: 200px\" >\r\n");
      out.write("\t\r\n");
      out.write("\t\t<form action=\"Navigator\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"form_id\" value=\"addprof\" >\r\n");
      out.write("\r\n");
      out.write("                <table>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>First Name</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td><input type=\"text\" size=\"30\" name=\"fname\"></td>\r\n");
      out.write("                    \t<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("                        <td>Last Name</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td><input type=\"text\" size=\"30\" name=\"lname\"></td>\r\n");
      out.write("                        \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Email</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td><input type=\"text\" size=\"30\" name=\"email\"></td>\r\n");
      out.write("                    \t<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("                        <td>Phone</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td><input type=\"text\" size=\"30\" name=\"phn\"></td>\r\n");
      out.write("                        \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>City</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td><input type=\"text\" size=\"30\" name=\"city\"></td>\r\n");
      out.write("                    \t<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("                        <td>Country</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                        \t<select name=\"country\">\r\n");
      out.write("                        \t\t<option value=\"India\">India</option>\r\n");
      out.write("                        \t\t<option value=\"US\">US</option>\r\n");
      out.write("                        \t\t<option value=\"UK\">UK</option>\r\n");
      out.write("                        \t\t<option value=\"Canada\">Canada</option>\r\n");
      out.write("                        \t</select>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Source</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td><input type=\"text\" size=\"30\" name=\"source\"></td>\r\n");
      out.write("                    \t<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("                        <td>Reference Employee Id</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td><input type=\"text\" size=\"30\" name=\"ref\"></td>\r\n");
      out.write("                        \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>LinkedIn Profile</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td><input type=\"text\" size=\"30\" name=\"linkedinprof\"></td>\r\n");
      out.write("                    \t<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("                        <td>Github Link</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td><input type=\"text\" size=\"30\" name=\"githublink\"></td>\r\n");
      out.write("                        \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Department</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                         <td><select name=\"dept\">\r\n");
      out.write("                                <option value=\"DE\">DE</option>\r\n");
      out.write("                                <option value=\"DS\">DS</option>\r\n");
      out.write("                                <option value=\"HR\">HR</option>\r\n");
      out.write("                                <option value=\"Finance\">Finance</option>\r\n");
      out.write("                                <option value=\"Marketing\">Marketing</option>\r\n");
      out.write("                                <option value=\"HealthEM\">HealthEM</option>\r\n");
      out.write("\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </td>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("                        <td>JOB ID</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td><input type=\"text\" size=\"30\" name=\"jobid\"></td>\r\n");
      out.write("\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Visa Status</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td><input type=\"text\" size=\"30\" name=\"visa\"></td>\r\n");
      out.write("                    \t<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("                        <td>Status</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <select name=\"status\">\r\n");
      out.write("                                <option value=\"Open\">Open</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Gender</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td><select name=\"gender\">\r\n");
      out.write("                                <option value=\"M\">Male</option>\r\n");
      out.write("                                <option value=\"M\">Female</option>\r\n");
      out.write("\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("                        <td>Ex-Tredence Employee</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <input type=\"checkbox\" name=\"exemp_flg\" id=\"exemp_flg\" onclick=\"showexempid()\">\r\n");
      out.write("                            <input type=\"text\" name=\"exempid\" id=\"exempid\" style=\"display:none\" value=\"Enter old employee id\" onclick=\"emptytext()\">\r\n");
      out.write("                        </td>\r\n");
      out.write("\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr></tr>\r\n");
      out.write("                    <tr></tr>\r\n");
      out.write("                     <tr>\r\n");
      out.write("                        <td colspan=\"3\" align=\"left\"> Upload Resume &nbsp;<input type=\"file\" name=\"resume\"></td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td>Tag</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"tag\"/></td>\r\n");
      out.write("                     </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr></tr>\r\n");
      out.write("                    <tr></tr>\r\n");
      out.write("                    <td colspan=\"7\" align=\"center\"><input type=\"submit\" value=\"Create Profile\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("function showexempid() {\r\n");
      out.write("  // Get the checkbox\r\n");
      out.write("  var checkBox = document.getElementById(\"exemp_flg\");\r\n");
      out.write("  // Get the output text\r\n");
      out.write("  var text = document.getElementById(\"exempid\");\r\n");
      out.write("\r\n");
      out.write("  // If the checkbox is checked, display the output text\r\n");
      out.write("  if (checkBox.checked == true){\r\n");
      out.write("    text.style.display = \"block\";\r\n");
      out.write("  } else {\r\n");
      out.write("    text.style.display = \"none\";\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("function emptytext(){\r\n");
      out.write("    document.getElementById(\"exempid\").value = \"\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
