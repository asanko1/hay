<html>
<head>
<script src="js/index.js">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.13.1/datatables.min.css"/>

<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.13.1/datatables.min.js"></script>
<script src="js/index.js"></script>
</head>
<body>
<table id="example" class="display" style="width:100%">
     			<tr>
     				<td>Profile Id</td>
     				<td>Name</td>
     				<td>Email</td>
     				<td>Phone</td>
     				<td>Status</td>
     				<td>Action</td>
     			</tr>

     			<tr>
     				<td>P-6</td>
     				<td>Asanko &nbsp;Basak</td>
     				<td>asanko.basak@test.com</td>
     				<td>4167326034</td>
     				<td>Open</td>
     				<td>
     						<a href="">View Interview Rounds</a> &nbsp;
     						<a href="">Blacklist</a> &nbsp;
     						<a href="">View Full Profile</a> &nbsp;
     				</td>
     			</tr>

     			<tr>
     				<td>P-7</td>
     				<td>Suvra &nbsp;Sarkar</td>
     				<td>suvra.sarkar@test.com</td>
     				<td>4167326034</td>
     				<td>Open</td>
     				<td>
     						<a href="">View Interview Rounds</a> &nbsp;
     						<a href="">Blacklist</a> &nbsp;
     						<a href="">View Full Profile</a> &nbsp;
     				</td>
     			</tr>

     			</table>
     			<script>
     			$(document).ready(function () {
                    $('#example').DataTable();
                });
                </script>
     			</body>
</html>