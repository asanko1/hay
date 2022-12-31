<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
            				<button class="dropbtn">Tasks</button>
            				<div class="dropdown-content">
            					<a href="#">My Pending Tasks</a>
            					<a href="#">My All Tasks</a>

            				</div>
            			</div>

			<div class="dropdown">
            				<button class="dropbtn">Logout</button>

            </div>
			
		</div>
	</div>
    <br>
            <%if(request.getParameter("u")!=null){%>
                        <center>
                        <font color="red" size="5">Hi! <%=request.getParameter("u")%></font>
                        </center>
            <%}%>

        <br>
	<div style="padding-left: 20px">
		
	</div>
</body>
</html>