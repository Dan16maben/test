<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="Bootstrap/css/Account.css">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<style>
body .{
	text-align: center;
}
</style>
</head>
<body>
<%
out.print(request.getSession(false).getAttribute("lastaccess"));
//long logouttime = (long) request.getSession(false).getAttribute("time1");
%>
<marquee><h1><font color="blue">HELLO WELCOME TO YOUR BANKING SYSTEM</font></h1></marquee>
	<center>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<p>
						<a href="Account.jsp" class="btn btn-sq-lg btn-primary"> <i
							class="fa fa-user fa-5x"></i><br /> Create Account
						</a> <a href="Deposit.jsp" class="btn btn-sq-lg btn-success"> <i
							class="fa fa-user fa-5x"></i><br /> Deposit
						</a> <a href="Withdraw.jsp" class="btn btn-sq-lg btn-info"> <i
							class="fa fa-user fa-5x"></i><br /> Withdraw
						</a> <a href="Balance.jsp" class="btn btn-sq-lg btn-warning"> <i
							class="fa fa-user fa-5x"></i><br /> Account Balance
							</a> <a href="Transaction.jsp" class="btn btn-sq-lg btn-danger"> <i
							class="fa fa-user fa-5x"></i><br /> Transaction
					  </a>  <a href="Logout" class="btn btn-sq-lg btn-primary"> <i
							class="fa fa-user fa-5x"></i><br /> Logout
						</a>
					</p>
				</div>
			</div>
		</div>
	</center>
</body>
</html>

