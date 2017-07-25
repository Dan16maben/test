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
<script type="text/javascript" src="bootstrap/js/Login.js"></script>
<link rel="stylesheet" href="Bootstrap/js/Login.js">
<link rel="stylesheet" href="Bootstrap/css/Login.css">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<section id="login">
		<div class="container">
			<div class="row">
				<div
					class="col-xs-12 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
					<h1>Login with your account</h1>
					<form role="form" action="Login" method="post" id="login-form"
						autocomplete="off">
						<div class="form-group">
							<label for="email" class="sr-only">Username</label> <input
								type="text" name="fname" id="email" class="form-control"
								placeholder="Username" required>
						</div>
						<div class="form-group">
							<label for="key" class="sr-only">Password</label> <input
								type="password" name="password" id="key" class="form-control"
								placeholder="Password" required>
						</div>
						<input type="submit" id="btn-login"
							class="btn btn-custom btn-lg btn-block" value="Log in">
					</form>
					<a href="javascript:;" class="forget" data-toggle="modal"
						data-target=".forget-modal">Forgot your password?</a>
					<hr />
				</div>
				<!-- /.col-xs-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</section>

	<div class="modal fade forget-modal" tabindex="-1" role="dialog"
		aria-labelledby="myForgetModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span> <span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">Recovery password</h4>
				</div>
				<div class="modal-body">
					<p>Type your email account</p>
					<input type="email" name="recovery-email" id="recovery-email"
						class="form-control" autocomplete="off">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-custom">Recovery</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</body>
</html>