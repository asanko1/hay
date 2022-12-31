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
        <%if(request.getParameter("u")!=null){%>
                    
                    <font color="red" size="5">Hi! <%=request.getParameter("u")%></font>
                    
        <%}%>

    <br>
	<div style="padding-left: 200px" >
	
		<form action="Navigator" method="post" enctype="multipart/form-data">
				<input type="hidden" name="form_id" value="addprof" >

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
                        <td>Source</td>
                        <td>&nbsp;</td>
                        <td><input type="text" size="30" name="source"></td>
                    	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>Reference Employee Id</td>
                        <td>&nbsp;</td>
                        <td><input type="text" size="30" name="ref"></td>
                        
                    </tr>
                    <tr>
                        <td>LinkedIn Profile</td>
                        <td>&nbsp;</td>
                        <td><input type="text" size="30" name="linkedinprof"></td>
                    	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>Github Link</td>
                        <td>&nbsp;</td>
                        <td><input type="text" size="30" name="githublink"></td>
                        
                    </tr>
                    <tr>
                        <td>Visa Status</td>
                        <td>&nbsp;</td>
                        <td><input type="text" size="30" name="visa"></td>
                    	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>Status</td>
                        <td>&nbsp;</td>
                        <td>
                            <select name="status">
                                <option value="Open">Open</option>
                            </select>
                        </td>
                        
                    </tr>
                    <tr></tr>
                    <tr></tr>
                     <tr>
                        <td colspan="7" align="center"> Upload Resume &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="file" name="resume"></td>
                     </tr>
                    <tr>
                    <tr></tr>
                    <tr></tr>
                    <td colspan="7" align="center"><input type="submit" value="Create Profile"></td>
                    </tr>
                </table>
		</form>
		
	</div>
</body>
</html>