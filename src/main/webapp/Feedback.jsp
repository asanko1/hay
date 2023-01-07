    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="ISO-8859-1">
    <title>H.A.Y::Login</title>

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
        <div class="header">
            <a href="#default" class="logo"><img src="images/logo.jpg"
                width="90" height="90"></a>


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

            <td><a  target="new" href="<%=request.getAttribute("teams_link").toString()%>" >Join Meeting</td>
            </TR>
            <tr></tr>
            <tr></tr>
            <tr>

            <td>Communication Skill</td>
            <td>
            <select name="comm">
                <option value="Select">Select</option>

                <option value="Excellent">Excellent</option>
                <option value="Good">Good</option>
                <option value="Moderate">Moderate</option>
                <option value="Moderate">Poor</option>
            </select>
            </td>
            <td>&nbsp;</td>
            <td>Business Skill</td>
            <td>
            <select name="biz">
                <option value="Select">Select</option>
                <option value="Not Applicable">Not Applicable</option>
                <option value="Sales Experience">Sales Experience</option>
                <option value="Marketing Experience">Marketing Experience</option>
                <option value="Supply Chain Experience">Supply Chain Experience</option>
                <option value="Healthcare Domain Expertise">Healthcare Domain Expertise</option>
                <option value="Corporate Legal Expertise">Corporate Legal Expertise</option>
            </select>
            </td>

            </TR>
            <tr>
                 <td>Technical Skills</td>

                 <td><select name="skills" id="skills" onchange="addSkills()">
                         <option value="">Select</option>
                         <option value="Not Applicable">Not Applicable</option>
                         <%for(int i=0;i<skills.size();i++){%>
                             <option value="<%=skills.get(i).getSkill_Name()%>"><%=skills.get(i).getSkill_Name()%></option>
                         <%}%>
                     </select>
                 </td>
                   <td>&nbsp;</td>
                 <td>Selected Skills</td>

                 <td>
                     <textarea name="skillset" id="skillset" rows="5" cols="30" > </textarea>
                     <button type="button" onclick="reset()">Reset</button>
                 </td>
             </tr>
             <tr>

            <td>Proposed Employment Type</td>
            <td>
            <select name="emp_type">
                <option value="Select">Select</option>
                <option value="Not Applicable">Not Applicable</option>
                <option value="Contractor">Contractor</option>
                <option value="Full Time">Full Time</option>

            </select>
            </td>
            <td>&nbsp;</td>
            <td>Proposed Designation</td>
            <td>
            <select name="desg">
                <option value="Select">Select</option>
                <option value="Not Applicable">Not Applicable</option>
                <option value="Consultant">Consultant</option>
                <option value="Associate Manager">Associate Manager</option>
                <option value="Manager">Manager</option>
                <option value="Sr. Manager">Sr. Manager</option>
                <option value="Director">Director</option>
            </select>
            </td>

            </TR>
             <TR>
            <td>Result</td>
            <td >
            <select name="result">
                <option value="Choose">Choose</option>
                <option value="Select">Select</option>
                <option value="Reject">Reject</option>
            </select>
            </td>
            <td>&nbsp;</td>
           <td>Additional Comment</td>
            <td >
            <textarea rows="5" cols="30" name="comment"></textarea>
            </td>
            </tr>
            <tr>
                <td colspan="5" align="center"><input type="submit" value="Confirm & Save" onclick="validate()"></td>
            </tr>
            </TABLE>
            <input type="hidden" name="form_id" value="finishround">
            <input type="hidden" name="round_id" value="<%=request.getParameter("TaskId") %>">
            <input type="hidden" name="profile_id" value="<%=request.getParameter("ProfileId") %>">
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