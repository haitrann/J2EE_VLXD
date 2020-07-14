<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Login</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Chrome, Firefox OS and Opera -->
<meta name="theme-color" content="#007bff" />
<!-- Windows Phone -->
<meta name="msapplication-navbutton-color" content="#007bff">
<!-- iOS Safari -->
<meta name="apple-mobile-web-app-status-bar-style" content="#007bff">

<!-- <link rel="icon" href="{{asset('img/ducfavicon.ico')}}" sizes="16x16"> -->
<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/public/lib/font-awesome/css/fontawesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/public/lib/font-awesome-5/css/fontawesome.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/public/lib/adminlte/css/adminlte.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/public/lib/iCheck/square/blue.css">
<!-- Google Font: Source Sans Pro -->
<style>
body {
	width: 360px;
	height: auto;
	z-index: -9999;
	margin-left: auto;
	margin-right: auto;
	margin-top: 80px;
	margin-bottom: auto;
}
canvas {
	background-color: #e9ecef;
	display: block;
	position: fixed;
	top: 0;
	left: 0;
	z-index: -9999;
}
</style>
</head>

<body>
	<!-- background animate -->
	<!-- <canvas id="dot-connect"></canvas> -->
	<canvas class="connecting-dots"></canvas>
	<!-- /.background animate -->
	<!-- Login -->
	<div class="login-box">

		<div class="login-logo ">
			<a href="./Home"><b class="text-primary font-weight-bold">THAI CONG INTERIOR</b></a>
		</div>
		<!-- /.login-logo -->

		<div class="card card-primary card-outline">
			<div class="card-header text-center">
				<span class="login-box-msg">WELCOME</span>
			</div>
			<!-- /.card-header -->

			<div class="card-body login-card-body">

				<form action="./SignInAuthServlet" method="POST">

					<!-- Email -->
					<div class="row">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa fa-envelope"></i></span>
							</div>
							<input id="username" type="Username" class="form-control"
								placeholder="Username" name="username" value="" required
								autofocus>
							<!-- <span class="fa fa-envelope form-control-feedback"></span> -->
							<!-- @error('email')
                            <span class="invalid-feedback" role="alert">
                                <strong>{{ $message }}</strong>
                            </span>
                            @enderror -->
						</div>
					</div>

					<!-- Password -->
					<div class="row">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa fa-lock"></i></span>
							</div>
							<input id="password" type="password" class="form-control"
								placeholder="Password" name="password">
							<!-- <span class="fa fa-lock form-control-feedback"></span> -->
							<!-- @error('password')
                            <span class="invalid-feedback" role="alert">
                                <strong>{{ $message }}</strong>
                            </span>
                            @enderror -->
						</div>
					</div>
					<!-- /.Password -->
					
					<span id='errorMessage' class="badge badge-danger">${errorMessage}</span>
					
					<!-- Sign in -->
					<div class="row">
						<div class="col-8"></div>
						<!-- /.col -->
						<div class="col-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat">LOGIN</button>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.Sign-in -->
					<br>
				</form>


				<p class="mb-0">
					<a href="#">Forgot password ?</a>
				</p>
				<p class="mb-1">
					<a href="AddUser">Create new account</a>
				</p>

			</div>
			<!-- /.login-card-body -->

			<!-- <div class="card-footer"></div> -->
		</div>
	</div>
	<!-- /.login-box -->

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/views/public/lib/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
		src="${pageContext.request.contextPath}/views/public/lib/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath}/views/public/lib/iCheck/icheck.min.js"></script>
	<!-- dot-connect -->
	<script
		src="${pageContext.request.contextPath}/views/public/lib/canvas-animation/dot-connect.js"></script>
	<!-- <script src="{{asset('lib/canvas-animation/dot-connect.min.js')}}"></script> -->

	<script>
		// $(function() {
		//     $('input').iCheck({
		//         checkboxClass: 'icheckbox_square-blue',
		//         radioClass: 'iradio_square-blue',
		//         increaseArea: '20%' // optional
		//     })
		// })
	</script>

</body>

</html>