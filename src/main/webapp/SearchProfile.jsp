<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <%@ page import = "com.tredence.hay.config.*" %>
 <%@ page import = "com.tredence.hay.controller.*" %>
 <%@ page import = "com.tredence.hay.model.*" %>
 <%@ page import = "java.util.*" %>
  <%@ page import = "java.io.*" %>
<head>
<meta charset="ISO-8859-1">
<title>H.A.Y::Login</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.13.1/datatables.min.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.13.1/datatables.min.css"/>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap4.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.13.1/datatables.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.13.1/datatables.min.js"></script>

<link rel="stylesheet" href="css/style.css">
<script src="js/index.js">

</script>
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
        <input type="hidden" name="form_id" value="searchprof">
        	<table>
        		<tr>
	        		<td>Search By</td>
	        		<td>
	        			<select name="search_by">
	        				<option value="profile_id">Profile Id</option>
	        				<option value="email">Email</option>
	        				<option value="phn">Phone</option>
	        				<option value="all">List All</option>
	        			</select>
	        		</td>
	        		<td>
	        			<input type="text" name="search_val" size="40"/>
	        		</td>
        		</tr>
        		<tr>
        			<td colspan="3" align="center"><input type="submit" value="Search"></td>
        		</tr>
        	</table>
        </form>
	</div>

    <% if(request.getParameter("msg")!=null){
    	if(request.getParameter("msg").equals("found_profile")){
    			ArrayList<Profile> profiles=new ArrayList<Profile>();
    			profiles=(ArrayList) session.getAttribute("profiles");
    			Profile pf=new Profile();
    			%>
    			<table id="example" class="display" style="width:100%">
    			<thead>
    			<tr>
    				<td>Profile Id</td>
    				<td>Name</td>
    				<td>Email</td>
    				<td>Phone</td>
    				<td>Status</td>
    				<td>Action</td>
    			</tr>
    			</thead>
    			<tbody>
    			<% for(int i=0;i<profiles.size();i++){
    					pf=profiles.get(i);%>

    			<tr>
    				<td><%= pf.getProfile_sythetic_key()%></td>
    				<td><%= pf.getFirst_name() %> &nbsp;<%= pf.getLast_name()%></td>
    				<td><%= pf.getPrimary_email()%></td>
    				<td><%= pf.getPrimary_phn()%></td>
    				<td><%= pf.getStatus()%></td>
    				<td align="center">
    						<a href="">Interview Rounds</a> &nbsp;
    						<a href="">Full Profile</a> &nbsp;
    						<a href="">Blacklist</a> &nbsp;
    				</td>
    			</tr>
    			<%} %>
    			</tbody>
    			</table>
    	<%} else if (request.getParameter("msg").equals("found_no_profile")){%>
    			<font color="red" size="5">No profile found</font>
    	<%}
    	}%>

</body>
<script>
$(document).ready(function () {
    $('#example').DataTable();
});
</script>
</html>