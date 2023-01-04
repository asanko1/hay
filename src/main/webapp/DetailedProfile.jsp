<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <%@ page import = "com.tredence.hay.config.*" %>
 <%@ page import = "com.tredence.hay.controller.*" %>
 <%@ page import = "com.tredence.hay.model.*" %>
 <%@ page import = "java.util.*" %>
<head>
<meta charset="ISO-8859-1">
<title>H.A.Y::Login</title>

<link rel="stylesheet" href="css/style.css">
<script src="js/index.js"></script>
</head>
<body>
	<div class="header">
		<a href="#default" class="logo"><img src="images/logo.jpg"
			width="90" height="90"></a>
		
			<div class="header-right" >
			<div class="dropdown">
				<button class="dropbtn">Home</button>
				
			</div>

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
			<div class="dropdown">
                <button class="dropbtn"><img src="images/logout.png" width="10" height="15"></button>
                <div class="dropdown-content">
                    <a href="Logout">Logout</a>

                </div>

            </div>
			
		</div>
	</div>
    <br>
        <div style="padding-left: 700px">
        <% if(session.getAttribute("email")!=null){ %>
                    <center>
                    <font color="blue" size="5">Hi! <%=session.getAttribute("email")%></font>
                    </center>
        <%}else{
                response.sendRedirect("index.jsp");
            }
        %>

        <%
            Profile pf =  (Profile) request.getAttribute("profile");
        %>
        </div>

        </div>
    <br>
	<div style="width:100%;">

    <div style="float:left; width:50%; " autofocus="autofocus">
    <table>
        <tr>
            <td>First Name</td>
            <td>&nbsp;</td>
            <td><input type="text" size="30" name="fname" readonly="readonly" value="<%=pf.getFirst_name()%>"></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>Last Name</td>
            <td>&nbsp;</td>
            <td><input type="text" size="30" name="lname" readonly="readonly" value="<%=pf.getLast_name()%>"></td>

        </tr>
        <tr>
            <td>Email</td>
            <td>&nbsp;</td>
            <td><input type="text" size="30" name="email" readonly="readonly" value="<%=pf.getPrimary_email()%>"></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>Phone</td>
            <td>&nbsp;</td>
            <td><input type="text" size="30" name="phn" readonly="readonly" value="<%=pf.getPrimary_phn()%>"></td>

        </tr>
        <tr>
            <td>City</td>
            <td>&nbsp;</td>
            <td><input type="text" size="30" name="city" readonly="readonly" value="<%=pf.getCity()%>"></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>Country</td>
            <td>&nbsp;</td>
            <td>
                <select name="country" disabled="true">
                	<%if(pf.getCountry().equals("India")){ %>
                	<option value="India" selected="selected">India</option>
                	<%}else{ %>
                	<option value="India">India</option>
                	<%} %>
                    
                    <%if(pf.getCountry().equals("US")){ %>
                	<option value="US" selected="selected">US</option>
                	<%}else{ %>
                	<option value="US">US</option>
                	<%} %>
                	
                	<%if(pf.getCountry().equals("UK")){ %>
                	<option value="UK" selected="selected">UK</option>
                	<%}else{ %>
                	<option value="UK">UK</option>
                	<%} %>
                    
                    <%if(pf.getCountry().equals("Canada")){ %>
                	<option value="Canada" selected="selected">Canada</option>
                	<%}else{ %>
                	<option value="Canada">Canada</option>
                	<%} %>
                	
                    
                </select>
            </td>

        </tr>
        <tr>
            <td>Source</td>
            <td>&nbsp;</td>
            <td><input type="text" size="30" name="source" readonly="readonly" value="<%=pf.getSource()%>"></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>Reference Employee Id</td>
            <td>&nbsp;</td>
            <td><input type="text" size="30" name="ref" readonly="readonly" value="<%=pf.getRef_emp_id()%>"></td>

        </tr>
        <tr>
            <td>LinkedIn Profile</td>
            <td>&nbsp;</td>
            <td><input type="text" size="30" name="linkedinprof" readonly="readonly" value="<%=pf.getLinkedin_url()%>"></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>Github Link</td>
            <td>&nbsp;</td>
            <td><input type="text" size="30" name="githublink" readonly="readonly" value="<%=pf.getGithub_url()%>"> </td>

        </tr>
        <tr>
            <td>Department</td>
            <td>&nbsp;</td>
             <td><select name="dept" disabled="true">

             		<%if(pf.getDept().equals("DE")){ %>
                	<option value="DE" selected="selected">DE</option>
                	<%}else{ %>
                	<option value="DE">DE</option>
                	<%} %>
                	
                	<%if(pf.getDept().equals("DS")){ %>
                	<option value="DS" selected="selected">DS</option>
                	<%}else{ %>
                	<option value="DS">DS</option>
                	<%} %>
                	
                	<%if(pf.getDept().equals("HR")){ %>
                	<option value="HR" selected="selected">HR</option>
                	<%}else{ %>
                	<option value="HR">HR</option>
                	<%} %>
             
                   <%if(pf.getDept().equals("Finance")){ %>
                	<option value="Finance" selected="selected">Finance</option>
                	<%}else{ %>
                	<option value="Finance">Finance</option>
                	<%} %>
                    
                    <%if(pf.getDept().equals("Marketing")){ %>
                	<option value="Marketing" selected="selected">Marketing</option>
                	<%}else{ %>
                	<option value="Marketing">Marketing</option>
                	<%} %>
                   
                   <%if(pf.getDept().equals("HealthEM")){ %>
                	<option value="HealthEM" selected="selected">HealthEM</option>
                	<%}else{ %>
                	<option value="HealthEM">HealthEM</option>
                	<%} %>
                   

                </select>
            </td>


            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>JOB ID</td>
            <td>&nbsp;</td>
            <td><input type="text" size="30" name="jobid" readonly="readonly" value="<%=pf.getJob_id()%>"></td>

        </tr>
        <tr>
            <td>Visa Status</td>
            <td>&nbsp;</td>
            <td><input type="text" size="30" name="visa" readonly="readonly" value="<%=pf.getVisa_status()%>"></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>Status</td>
            <td>&nbsp;</td>
            <td>
                <select name="status">
                    <option value="Open" readonly="readonly">Open</option>
                </select>
            </td>

        </tr>
        <tr>
            <td>Gender</td>
            <td>&nbsp;</td>
            <td><select name="gender" disabled="true">
            		<%if(pf.getGender().equals("M")){ %>
                	<option value="M" selected="selected">Male</option>
                	<%}else{ %>
                	<option value="M">Male</option>
                	<%} %>
                    
                    <%if(pf.getGender().equals("F")){ %>
                	<option value="F" selected="selected">Female</option>
                	<%}else{ %>
                	<option value="F">Female</option>
                	<%} %>
                    

                </select>
            </td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>Ex-Tredence Employee</td>
            <td>&nbsp;</td>
            <td>
             <%System.out.println(pf.getExemp_id());%>
            <%if(pf.getExemp_flg()!=null){
                if(pf.getExemp_flg().trim().equals("on")){%>
                        <input type="checkbox" name="exemp_flg" id="exemp_flg" checked="checked" disabled="true">
                        <%}else{%>
                          <input type="checkbox" name="exemp_flg" id="exemp_flg"  disabled="true">
                        <%}}%>

                <input type="text" name="exempid" id="exempid" readonly="readonly" value="<%=pf.getExemp_id()%>" >
            </td>

        </tr>
        <tr></tr>
        <tr></tr>
         <tr>
            <td colspan="3" align="left"> Download Resume &nbsp;</td>
            <td>&nbsp;</td>
            <td>Tag</td>
            <td>&nbsp;</td>
            <td>

            <input type="text" name="tag" readonly="readonly" value="<%=pf.getTag()%>">
            </td>
         </tr>

        <tr></tr>
        <tr></tr>
       <!-- <td colspan="7" align="center"><input type="button" value="Reset" type="button">
        <input type="submit" value="Update Profile"></td> -->
        </tr>
    </table>
    </div>
    <div style="float:right; width:50%; ">

	</div>
</body>
</html>