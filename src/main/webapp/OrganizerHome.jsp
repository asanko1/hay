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
        </div>
                        <% 	if(request.getParameter("dupid")!=null){%>

                                   <center>
                                   <font color="red" size="5">A matching profile <a href=""><%=request.getParameter("dupid")%></a> found.</font>
                                   </center>

                       	<%}
                        else if(request.getParameter("profileid")!=null){%>

                           <center>
                           <font color="green" size="5">New Candidate Profile <a href=""><%=request.getParameter("profileid")%></a> Created.</font>
                           </center>
                       <%}
                    	else if (request.getParameter("orgid")!=null){%>
                            <center>
                               <font color="green" size="5">New Organizer <a href=""><%=request.getParameter("orgid")%></a> Created.</font>
                            </center>
               	        <%}else if (request.getParameter("pnlid")!=null){%>
               	            <center>
                               <font color="green" size="5">New Panelist <a href=""><%=request.getParameter("pnlid")%></a> Created.</font>
                            </center>
                        <%}%>
        </div>
    <br>
	<div style="padding-left: 20px">
		<div class="tab" >
          <button class="tablinks" onclick="openCity(event, 'London')">My Tasks</button>
          <button class="tablinks" onclick="openCity(event, 'Paris')">My Reports</button>
          <button class="tablinks" onclick="openCity(event, 'Tokyo')">Leadership Reports</button>
        </div>

        <div id="London" class="tabcontent">
          <h3>London</h3>
          <p>London is the capital city of England.</p>
        </div>

        <div id="Paris" class="tabcontent">
          <h3>Paris</h3>
          <p>Paris is the capital of France.</p>
        </div>

        <div id="Tokyo" class="tabcontent">
          <h3>Tokyo</h3>
          <p>Tokyo is the capital of Japan.</p>
        </div>
	</div>
	<script>
    function openCity(evt, cityName) {
      var i, tabcontent, tablinks;
      tabcontent = document.getElementsByClassName("tabcontent");
      for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
      }
      tablinks = document.getElementsByClassName("tablinks");
      for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
      }
      document.getElementById(cityName).style.display = "block";
      evt.currentTarget.className += " active";
    }
    </script>
</body>
</html>