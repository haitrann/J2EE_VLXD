<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Goods Receipt</title>
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
							<h1>Goods Receipt</h1>
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
									<h3 class="card-title  p-3">Goods Receipt</h3>
								</div>

								<div class="card-body">
									<form class="form" action="./CreateNewUserServlet"
										method="POST">


										<div class="row">
											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Vendor</label>
													<div>
														<input id="name" name="name" type="text"
															class="form-control" value="" placeholder="Vendor name">
													</div>
												</div>
												<!-- /input-group -->
											</div>
											<!-- /.col-md-5 -->

											<div class="col-md-2"></div>

											<div class="col-md-5"></div>
										</div>

										<div class="row">
											<div class="col-md-5">
												<input id="id" name="id" type="hidden" value="1">
												<button type="button" class="btn btn-success">
													Vendor <span class="badge badge-light">Sun house</span>
												</button>
											</div>
										</div>

										<br>

										<div class="card-body">
											<div class="table-responsive">
												<table id="projectTable"
													class="table table-bordered table-hover">
													<thead>
														<tr>
															<th>Ordinal Numbers</th>
															<th>Product</th>
															<th>Quantity</th>
															<th>Unit Price</th>
															<th>Total</th>
															<th>Remove</th>
														</tr>
													</thead>
													<tbody>

													</tbody>
												</table>

											</div>
										</div>

										<div class="row">
											<div class="col-md-5 col-5"></div>
											<div class="col-md-2"></div>
											<div class="col-md-5 col-5">
												<h4>
													Amount payable: <span class="badge badge-danger ml-1">10.000.000</span>
												</h4>
											</div>
										</div>
										
										<div class="row justify-content-end">
											<div class="col-md-5 d-flex flex-row">
												<h4 style="width: 251px;">Amount paid:</h4> 
												<input class="form-control" id="paid" name="paid" type="text">
											</div>
										</div>
										
										<br>
										
										<div class="row justify-content-end">
											<div class="col-md-5 d-flex flex-row">
												<h4 style="width: 251px;">Debt:</h4> 
												<input class="form-control" id="inputsm" type="text">
											</div>
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
		$(document).ready(function() {
			$("#paid").on({
				input : function() {
					formatCurrency($(this));
				}
			});
		});

		function formatNumber(n) {
			//return n.replace(/\D/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ".");
			return Number(n.replace(/\./g, '')).toLocaleString('vi');
		}

		function formatCurrency(input) {
			var input_val = input.val();

			if (input_val === "") {
				return;
			}
			
			var original_len = input_val.length;

			var caret_pos = input.prop("selectionStart");

			input_val = formatNumber(input_val);

			input.val(input_val);

			var updated_len = input_val.length;
			caret_pos = updated_len - original_len + caret_pos;
			input[0].setSelectionRange(caret_pos, caret_pos);
		}
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