<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <%@ page import = "com.tredence.hay.config.*" %>
 <%@ page import = "com.tredence.hay.controller.*" %>
 <%@ page import = "com.tredence.hay.model.*" %>
 <%@ page import = "java.util.*" %>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>H.A.Y::Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/js/standalone/selectize.min.js" integrity="sha256-+C0A5Ilqmu4QcSPxrlGpaZxJ04VjsRjKu+G82kl5UJk=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/css/selectize.bootstrap3.min.css" integrity="sha256-ze/OEYGcFbPRmvCnrSeKbRTtjG4vGLHXgOqsyLFTRjg=" crossorigin="anonymous" />

<link rel="stylesheet" href="css/style.css">
<script src="js/index.js"></script>
<style>
.collapsible {
  background-color: #11A3EB;
  color: white;
  cursor: pointer;
  padding: 18px;
  width: 90%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
}

.active, .collapsible:hover {
  background-color: #555;
}

.content {
  padding: 0 18px;
  display: none;
  overflow: hidden;
  background-color: #f1f1f1;
}
</style>
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
    <div style="float:right; width:50%; padding-left:50px ">
        <%
            int panelist_type=0;
            ArrayList<Round> rounds=new ArrayList<Round>();
            rounds=(ArrayList<Round>) request.getAttribute("rounds");
            if(rounds.size()==0){
            panelist_type=0;
            %>

               <center> <font color="green" size="3"> No interview rounds scheduled yet! <button type="button" onclick="showscrroundform()">Start now</button> </font> </center>

        <%}else{
             panelist_type=1;
            for(int i=0;i<rounds.size();i++){
        %>
            <button type="button" class="collapsible"> <b>Round Type:</b> <%= rounds.get(i).getRound_type()%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Status:</b><%= rounds.get(i).getStatus()%></button>
            <div class="content">
              <b>Interviewed on:</b> <%= rounds.get(i).getScheduled_on()%> <br>
              <b>Interviewed By:</b> <%= rounds.get(i).getPanelist_id()%>
            </div>
            <%}%>
            <br>
            <br>
            <button type="button" onclick="showscrroundform()">Schedule Next Round</button>
            <%}%>


        <br><br>

        <center>
        <div id="roundform" style="display:none">
        <form action="Navigator" method="post">
        <input type="hidden" name="form_id" value="createscrround">
        <input type="hidden" name="profile_id" value="<%=pf.getProfile_sythetic_key()%>">
        <table id="scrroundform" >
            <th> <td colspan="2"> Create New Interview Round </td> </th>
            <tr>
                <td>Round Name</td>
                <td>
                    <select name="roundname">
                        <% if (panelist_type == 0) {%>
                        <option value="Screening">Screening</option>
                        <%}else{%>
                        <option value="Round 1">Round 1</option>
                        <option value="Round 2">Round 2</option>
                        <option value="Round 3">Round 3</option>
                        <%}%>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Round Type</td>
                <td>
                    <select name="roundtype">
                        <% if (panelist_type == 0) {%>
                        <option value="HR Screening">HR Screening</option>
                        <%}else{%>
                        <option value="Technical">Technical</option>
                        <option value="Business">Business</option>
                        <option value="Leadership">Leadership</option>
                        <%}%>
                    </select>
                </td>
            </tr>
            <tr>

                    <td>Mode</td>
                    <td>
                    <select name="mode">
                        <option value="Telephonic">Telephonic</option>
                        <option value="Teams">Teams</option>
                    </select>
                    </td>

            </tr>
            <tr>

                    <td>Panelist</td>
                    <td>
                        <% if (panelist_type == 0) {%>
                        <select name="Panelist" >
                        <option value="Select">Select</option>
                        <%
                        ArrayList<Organizer> orgs=new ArrayList<Organizer>();
                        orgs=(ArrayList<Organizer>) request.getAttribute("orgs");
                        for(int i=0;i<orgs.size();i++){ %>
                            <option value="<%=orgs.get(i).getEmail()%>"><%=orgs.get(i).getEmail()%></option>
                        <%}%>

                        <%}else{%>
							<select name="Panelist" >
                            <option value="Select">Select</option>
                            <% 
                            ArrayList<Panelist> pnls=new ArrayList<Panelist>();
                            pnls=(ArrayList<Panelist>) request.getAttribute("pnls");
                            for(int i=0;i<pnls.size();i++){ %>
                                <option value="<%=pnls.get(i).getEmail()%>"><%=pnls.get(i).getEmail()%></option>
                            <%}%>
                        <%}%>
                     </td>
                    </select>

            </tr>
            <tr>

                    <td>Time</td>
                    <td><input type="datetime-local" id="scheduled_on" name="scheduled_on"></td>
            </tr>
            <tr>
                    <td>Timezone</td>
                    <td><select name="timezone">
                            <option value="ATL">ATL</option>
                            <option value="CST">CST</option>
                            <option value="EST">EST</option>
                            <option value="GMT">GMT</option>
                            <option value="IST">IST</option>
                            <option value="PST">PST</option>
                        </select>
                    </td>

            </tr>
            <tr>
                    <td>Duration</td>
                    <td><select name="duration">
                            <option value="15 minutes">15 minutes</option>
                            <option value="30 minutes">30 minutes</option>
                            <option value="45 Minutes">45 Minutes</option>
                            <option value="60 Minutes">60 Minutes</option>
                        </select>
                    </td>

            </tr>
            <tr>

                                <td colspan="2" align="center">
                                    <input type="submit" value="Confirm & Schedule"/>
                                </td>

                        </tr>
        </table>
        </form>

        </div>
        </center>
	</div>
	<script>
    var coll = document.getElementsByClassName("collapsible");
    var i;

    for (i = 0; i < coll.length; i++) {
      coll[i].addEventListener("click", function() {
        this.classList.toggle("active");
        var content = this.nextElementSibling;
        if (content.style.display === "block") {
          content.style.display = "none";
        } else {
          content.style.display = "block";
        }
      });
    }

    </script>
</body>
<script>
 $(document).ready(function () {
      $('select').selectize({
          sortField: ''
      });
  });
function showscrroundform() {


  var x = document.getElementById("roundform");
    if (x.style.display === "none") {
      x.style.display = "";
    } else {
      x.style.display = "none";
    }
 return;
}


</script>

</html>