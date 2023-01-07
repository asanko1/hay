    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="ISO-8859-1">
    <title>H.A.Y::Login</title>
 <%@ page import = "com.tredence.hay.config.*" %>
 <%@ page import = "com.tredence.hay.controller.*" %>
 <%@ page import = "com.tredence.hay.model.*" %>
 <%@ page import = "java.util.*" %>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/index.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/js/standalone/selectize.min.js" integrity="sha256-+C0A5Ilqmu4QcSPxrlGpaZxJ04VjsRjKu+G82kl5UJk=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/css/selectize.bootstrap3.min.css" integrity="sha256-ze/OEYGcFbPRmvCnrSeKbRTtjG4vGLHXgOqsyLFTRjg=" crossorigin="anonymous" />
    </head>
     <%@ page import = "com.tredence.hay.config.*" %>
     <%@ page import = "com.tredence.hay.controller.*" %>
     <%@ page import = "com.tredence.hay.model.*" %>
     <%@ page import = "java.util.*" %>
    <body>
    <%if(session.getAttribute("email")!=null){%>

                        <font color="blue" size="5">Hi! <%=session.getAttribute("email")%></font>

            <%}%>
            <% if(session.getAttribute("email")==null){
                                 response.sendRedirect("index.jsp");
                   }%>
        <div class="header">
            <a href="#default" class="logo"><img src="images/logo.jpg"
                width="90" height="90"></a>
<div class="header-right" >
			<div class="dropdown">
				<button class="dropbtn">Home</button>
				<div class="dropdown-content">
                                    <a href="Navigator?form_id=returnhome">Dashboard</a>
                                </div>
			</div>
            <%if(session.getAttribute("role").equals("Organizer")){%>
			<div class="dropdown">
				<button class="dropbtn">Profile</button>
				<div class="dropdown-content">
					<a href="AddProfile.jsp">Add New Profile</a>
					<a href="SearchProfile.jsp">Manage Profile</a>

				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">Organizer</button>
				<div class="dropdown-content">
					<a href="AddOrganizer.jsp">Add New Organizer</a>
					<a href="#">Manage Organizer</a>

				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">Panelist</button>
				<div class="dropdown-content">
					<a href="AddPanelist.jsp">Add New Panelist</a>
					<a href="#">Manage Panelist</a>
				</div>
			</div>
			<%}%>
			<div class="dropdown">
                <button class="dropbtn"><img src="images/logout.png" width="10" height="15"></button>
                <div class="dropdown-content">
                    <a href="Logout">Logout</a>

                </div>

            </div>

		</div>

        </div>
         <% if(session.getAttribute("email")!=null){ %>



                <%}else{
                        response.sendRedirect("index.jsp");
                    }
                %>
     <%
                    ArrayList<Skills> skills=new  ArrayList<Skills>();
                    ManageSkills ms=new ManageSkills();
                    skills=ms.getAllSkills();

                    Feedback fd=new Feedback();
                    ManageFeedback mf=new ManageFeedback();
                    fd=mf.getFeedback(request.getParameter("TaskId"));
            %>

        <div style="padding-left: 20px">
        <center>
        <form action="Navigator" method="post">

            <TABLE>


            <TR>
            <td ><b>Round Id</b></td>
            <td><%=request.getParameter("TaskId") %></td>
            <td>&nbsp;</td>
            <td ><b>Candidate Profile Id</b></td>
            <td><%=request.getParameter("ProfileId") %></td>

            </TR>
            <tr></tr>
            <tr></tr>
            <tr>

            <td>Communication Skill</td>
            <td>
            <input type="text" readonly="readonly" value="<%=fd.getComm_Score()%>">
            </td>
            <td>&nbsp;</td>
            <td>Business Skill</td>
            <td>
            <input type="text" readonly="readonly" value="<%=fd.getBiz_Skill_Score()%>">
            </td>

            </TR>
            <tr>
                 <td>Technical Skills</td>

                 <td>
                     <textarea name="skillset" id="skillset" rows="5" cols="30" readonly="readonly" > <%=fd.getTech_Skill_Score()%></textarea>
                     <%System.out.println(fd.getTech_Skill_Score());%>
                 </td>
             </tr>
             <tr>

            <td>Proposed Employment Type</td>
            <td>
            <input type="text" readonly="readonly" value="<%=fd.getProposed_Employment_type()%>">
            </td>
            <td>&nbsp;</td>
            <td>Proposed Designation</td>
            <td>
           <input type="text" readonly="readonly" value="<%=fd.getProposed_Designation()%>">
            </td>

            </TR>
             <TR>
            <td>Result</td>
            <td >
            <input type="text" readonly="readonly" value="<%=fd.getResult()%>">
            </td>
            <td>&nbsp;</td>
           <td>Additional Comment</td>
            <td >
            <textarea rows="5" cols="30" name="comment"  readonly="readonly"><%=fd.getComment()%></textarea>
            <%System.out.println(fd.getComment());%>
            </td>
            </tr>
           
            </TABLE>

            </form>
            </center>
        </div>
        <script>
        function addSkills()
          {

             document.getElementById("skillset").value =  document.getElementById("skillset").value + '\n'+ document.getElementById("skills").value + ':';
          }
          function reset()
          {
            document.getElementById("skillset").value=''
          }
          function validate(){

          }
        </script>
    </body>
    </html>