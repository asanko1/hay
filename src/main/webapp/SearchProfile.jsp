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
				<button class="dropbtn">Profile</button>
				<div class="dropdown-content">
					<a href="AddProfile.jsp">Add New Profile</a>
					<a href="#">Manage Profile</a>

				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">Organizer</button>
				<div class="dropdown-content">
					<a href="#">Add New Organizer</a>
					<a href="#">Manage Organizer</a>

				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">Panelist</button>
				<div class="dropdown-content">
					<a href="#">Add New Panelist</a>
					<a href="#">Manage Panelist</a>
				</div>
			</div>
			<div class="dropdown">
            				<button class="dropbtn">Logout</button>

            </div>

		</div>
	</div>
    <br>
        <div style="padding-left: 700px">
        <% if(session.getAttribute("email")!=null){ %>
                   
                    <font color="blue" size="5">Hi! <%=session.getAttribute("email")%></font>
                    
        <%}else{
                response.sendRedirect("index.jsp");
            }
        %>
        </div>

    <br>
	<div style="padding-left: 20px">
        <form action="Navigator" method="post" >
        	<table>
        		<tr>
	        		<td>Search By</td>
	        		<td>
	        			<select>
	        				<option value="profile_id">Profile Id</option>
	        				<option value="profile_id">Email</option>
	        				<option value="profile_id">Phone</option>
	        			</select>
	        		</td>
	        		<td>
	        			<input type="text" name="search_by" size="40"/>
	        		</td>
        		</tr>
        		<tr>
        			<td colspan="3" align="center"><input type="submit" value="Search"></td>
        		</tr>
        	</table>
        </form>
	</div>
</body>
</html>