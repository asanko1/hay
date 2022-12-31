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
</head>
<body>
	<div class="header">
		<a href="#default" class="logo"><img src="images/logo.jpg"
			width="90" height="90"></a>
		

	</div>
	<br>
	<%
	if(request.getParameter("e")!=null){
        if(request.getParameter("e").equals("login_fail")){%>
            <center>
            <font color="red" size="5">Login failed. Please select userid and role correctly.</font>
            </center>
        <%}
	}
	%>
	<br>

	<div style="padding-left: 500px">
	<form method="post" action="Navigator">
		<input type="hidden" name="form_id" value="login">
		<%
		    ManageUsers mu=new ManageUsers();
		    ArrayList<Users> users=mu.getAllUsers();
		    
		%>
		<table>
			<tr>
				<td>Email</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td align="center">
				<select name="userid">
				    <option>Select</option>
				    <%for(int i=0;i<users.size();i++){%>

				        <option value="<%=users.get(i).getEmail()%>"><%=users.get(i).getEmail()%></option>
				    <%}%>
				</select>
				</td>
			</tr>
			<tr>
				<td>Role</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td align="center">
					<select name="role">
						<option>Select</option>
						<option>Organizer</option>
						<option>Panelist</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center"> <input type="submit" value="Enter" ></td>
				
			</tr>
		</table>
		
		</form>
	</div>
</body>
</html>