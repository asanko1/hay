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
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/js/standalone/selectize.min.js" integrity="sha256-+C0A5Ilqmu4QcSPxrlGpaZxJ04VjsRjKu+G82kl5UJk=" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/css/selectize.bootstrap3.min.css" integrity="sha256-ze/OEYGcFbPRmvCnrSeKbRTtjG4vGLHXgOqsyLFTRjg=" crossorigin="anonymous" />

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
	}else if(request.getParameter("logout")!=null){
	 if(request.getParameter("logout").equals("Y")){
	%>
	            <center>
                <font color="red" size="5">You have successfully logged out</font>
                </center>
	<%}}%>
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
				<select name="userid" id="userid" >
				    <option value="">Please select your email address</option>
				    <%for(int i=0;i<users.size();i++){

				    %>
				        <option value="<%=users.get(i).getEmail()%>"><%=users.get(i).getEmail()%></option>
				    <%}%>
				</select>
				</td>
			</tr>
			<tr>
				<td>Role</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td align="center">
					<select name="role" >
						<option>Select</option>
						<option value="Organizer">Organizer</option>
						<option value="Panelist">Panelist</option>
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
<script>
  $(document).ready(function () {
      $('select').selectize({
          sortField: ''
      });
  });
  </script>
</html>