<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Add User</title>
<%@include file="../layouts/importstyle.jsp"%>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-latest.pack.js"></script>
</head>

<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<%@include file="../layouts/navbar.jsp"%>
		<%@include file="../layouts/sidebar.jsp"%>
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>Add New User</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="">Home</a></li>
								<li class="breadcrumb-item active">Add</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</div>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<div class="card card-primary card-outline">
								<div class="card-header  d-flex p-0">
									<h3 class="card-title  p-3">Add New User</h3>
								</div>

								<div class="card-body">
									<form class="form" action="./CreateNewUserServlet"
										method="POST">


										<div class="row">
											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Name</label>
													<div>
														<input id="name" name="name" type="text"
															class="form-control" value="" placeholder="Full name">
													</div>
												</div>
												<!-- /input-group -->
											</div>
											<!-- /.col-md-5 -->

											<div class="col-md-2"></div>

											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Username</label> <span
														id='confirm_username_message'></span>
													<div>
														<input id="username" name="username" type="text"
															class="form-control" maxlength="255" value=""
															placeholder="The number of characters is greater than 6">
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Email</label>
													<div>
														<input id="email" name="email" type="email"
															class="form-control" maxlength="255" value=""
															placeholder="Email">
													</div>
												</div>
											</div>

											<div class="col-md-2"></div>

											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Password</label>
													<div>
														<input id="password" name="password" type="password"
															class="form-control" maxlength="255" value=""
															placeholder="Password">
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Phone</label>
													<div>
														<input id="phone" name="phone" type="text"
															class="form-control" maxlength="255" value=""
															placeholder="Phone">
													</div>
												</div>
											</div>

											<div class="col-md-2"></div>

											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Retype password</label> <span
														id='confirm_password_message'></span>
													<div>
														<input id="confirm_password" name="confirm_password" type="password"
															class="form-control" maxlength="255" value=""
															placeholder="Retype password">
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Role</label>
													<div>
														<select id="role" name="role" class="form-control"
															onchange="RoleFunction()">
															<option selected>Choose...</option>
															<option value="manager">Manager</option>
															<option value="employee">Employee</option>
														</select>
													</div>
												</div>
											</div>

											<div class="col-md-2"></div>

											<div class="col-md-5"></div>
										</div>

										<div class="row">
											<div class="col-md-5 col-5">
												<div class="form-group">
													<a href="">
														<button type="button" class="btn btn-outline-danger">Cancel</button>
													</a>
												</div>
											</div>
											<div class="col-md-2"></div>
											<div class="col-md-5 col-5">
												<button type="submit" class="btn  btn-primary">Create</button>
											</div>
										</div>
									</form>
								</div>
								<!-- /.form -->
							</div>
							<!-- /.card-body -->

						</div>
						<!-- /.card -->
					</div>
					<!-- /.col -->
				</div>
			</section>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function () {
			$('#password, #confirm_password').on('keyup', function () {
				if ($('#password').val() == $('#confirm_password').val()) {
					$('#confirm_password_message').html('Matching').css('color', 'green');
				} else
					$('#confirm_password_message').html('Not Matching').css('color', 'red');
			});


			$("#username").blur(function () {
				var usernameInput = $("#username").val();
				if (usernameInput.length > 6) {
					$.ajax({
						type: "POST",
						url: "./CheckUsernameAvailableServlet",
						data: {
							usernameInput: usernameInput
						},
						success: function (responseText) {
							if (responseText == "The username is not valid") {
								$('#confirm_username_message').html(responseText).css('color', 'red');
							} else {
								$('#confirm_username_message').html(responseText).css('color', 'green');
							}

						}
					});
				} else {
					$('#confirm_username_message').html('The username is not valid').css('color', 'red');
				}
			});
		});
	</script>

	<footer class="main-footer">
		<!-- To the right -->
		<div class="float-right d-none d-sm-block-down">Anything you
			want</div>
		<!-- Default to the left -->
		<strong> &nbsp; Copyright &copy; 2020 <a href="#">QL-VLXD</a>.
		</strong> All rights reserved. <br>
	</footer>

	<%@include file="../layouts/importscript.jsp"%>

</body>

</html>