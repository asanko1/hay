<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>H.A.Y::Add New Panelist</title>
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
    <br>
        <%if(request.getParameter("u")!=null){%>
                    
                    <font color="blue" size="5">Hi! <%=request.getParameter("u")%></font>
                    
        <%}%>
        <% if(session.getAttribute("email")==null){
                             response.sendRedirect("index.jsp");
                }%>

	<div style="padding-left: 200px" >
	    <%
                ArrayList<Skills> skills=new  ArrayList<Skills>();
                ManageSkills ms=new ManageSkills();
                skills=ms.getAllSkills();
	    %>
		<form action="Navigator" method="post" >
				<input type="hidden" name="form_id" value="addpnl" >

                <table>
                    <tr>
                        <td>First Name</td>
                        <td>&nbsp;</td>
                        <td><input type="text" size="30" name="fname"></td>
                    	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>Last Name</td>
                        <td>&nbsp;</td>
                        <td><input type="text" size="30" name="lname"></td>
                        
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>&nbsp;</td>
                        <td><input type="text" size="30" name="email"></td>
                    	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>Phone</td>
                        <td>&nbsp;</td>
                        <td><input type="text" size="30" name="phn"></td>
                        
                    </tr>
                    <tr>
                        <td>City</td>
                        <td>&nbsp;</td>
                        <td><input type="text" size="30" name="city"></td>
                    	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>Country</td>
                        <td>&nbsp;</td>
                        <td>
                        	<select name="country">
                        		<option value="India">India</option>
                        		<option value="US">US</option>
                        		<option value="UK">UK</option>
                        		<option value="Canada">Canada</option>
                        	</select>
                        </td>
                        
                    </tr>
                    <tr>
                        <td>Department</td>

                        <td>
                             <td><select name="dept">
                                    <option value="DE">DE</option>
                                    <option value="DS">DS</option>
                                    <option value="HR">HR</option>
                                    <option value="Finance">Finance</option>
                                    <option value="Marketing">Marketing</option>
                                    <option value="HealthEM">HealthEM</option>

                                </select>
                            </td>
                        </td>
                    	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>Leadership User</td>
                        <td>&nbsp;</td>
                        <td><input type="checkbox" name="leadership" id="leadership" ></td>
                        
                    </tr>
                    <tr>
                        <td>Timezone</td>
                        <td>&nbsp;</td>
                        <td><select name="timezone">
                                <option value="ATL">ATL</option>
                                <option value="CST">CST</option>
                                <option value="EST">EST</option>
                                <option value="GMT">GMT</option>
                                <option value="IST">IST</option>
                                <option value="PST">PST</option>
                            </select>
                        </td>
                    	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>Linkedin Profile</td>
                        <td>&nbsp;</td>
                        <td><input type="text" size="30" name="linkedinurl"></td>
                        
                    </tr>
                    <tr>
                        <td>Skills</td>
                        <td>&nbsp;</td>
                        <td><select name="skills" id="skills" onchange="addSkills()">
                                <option value="">Select</option>
                                <%for(int i=0;i<skills.size();i++){%>
                                    <option value="<%=skills.get(i).getSkill_Name()%>"><%=skills.get(i).getSkill_Name()%></option>
                                <%}%>
                            </select>
                        </td>
                        <td>&nbsp;</td>
                        <td>Selected Skills</td>
                        <td>&nbsp;</td>
                        <td>
                            <textarea name="skillset" id="skillset" rows="5" cols="30" readonly="readonly">Skills: </textarea>
                            <button type="button" onclick="reset()">Reset</button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <td colspan="7" align="center"><input type="submit" value="Create Profile"></td>
                    </tr>
                </table>
		</form>
		
	</div>
</body>
<script>
  $(document).ready(function () {
      $('select').selectize({
          sortField: 'text'
      });
  });
  function addSkills()
  {

     document.getElementById("skillset").value =  document.getElementById("skillset").value + document.getElementById("skills").value + ';';
  }
  function reset()
  {
    document.getElementById("skillset").value='Skills: '
  }
</script>
</html>