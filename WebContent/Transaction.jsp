<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="Bootstrap/js/Account.js">
<link rel="stylesheet" href="Bootstrap/js/Saving.js">
<link rel="stylesheet" href="Bootstrap/css/Saving.css">
<style type="text/css">
.btn-radio {
	width: 100%;
}

.img-radio {
	opacity: 0.5;
	margin-bottom: 5px;
}

.space-20 {
	margin-top: 20px;
}

body {
	padding-top: 50px;
}

.bigger p {
	padding-top: 13px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Transaction" method="post">
		<br />
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<form class="form-horizontal well" role="form">
						<div class="row space-20">
							<div class="col-xs-12">
								<div class="form-group">
									<label for="inputTitle" class="col-sm-2 control-label">ACCOUNT
										NUMBER</label>
									<div class="col-sm-10">
										<input type="text" name="accountno" class="form-control"
											id="inputTitle" required>
									</div>
								</div>
							</div>
						</div>
						<br>
					</form>
					<div class="container">
						<div class="row">
							<div class="col-md-1">

								<!-- Indicates a successful or positive action -->
								<input type="Submit" class="btn btn-success">
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</form>
</body>
</html>