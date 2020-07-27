<%@page import="vlxd.dto.WarehouseDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Warehouse</title>
<%@include file="../layouts/importstyle.jsp"%>
<style>
.hovermouse {
	cursor: -webkit-grab;
	cursor: grab;
	color: #007bff;
	text-decoration: underline;
}

.hovermouse:hover {
	color: #0056b3;
}
</style>
</head>

<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<%@include file="../layouts/navbar.jsp"%>
		<%@include file="../layouts/sidebar.jsp"%>

		<!-- content Add, List, Edit -->

		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">Stock Take Of Goods Receipt Details</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Add</li>
							</ol>
						</div>
					</div>
				</div>
			</div>

			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12 connectedSortable ui-sortable">
							<div class="card card-primary card-outline">
								<div class="card-header">
									<h3 class="card-title">Stock Take Of Goods Receipt Details</h3>
								</div>

								<div class="card-body">
									<div class="table-responsive">
										<table id="projectTable"
											class="table table-bordered table-hover">
											<thead>
												<tr>
													<th>Id</th>
													<th>Product</th>
													<th>Quantity</th>
													<th>Unit Price (VND)</th>
													<th>Total (VND)</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${goodsReceiptDetails}" var="list">
													<tr>
														<td>${list.getId()}</td>
														<td>${list.getProduct().getName()}</td>
														<td>${list.getQuantity()}</td>
														<td class="currency">${list.getUnitPrice()}</td>
														<td class="currency">${list.getTotal()}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>

								<div class="card-footer"></div>
							</div>
							<!-- /.card -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
			</section>
			<!-- /.content -->

		</div>
		<!-- end content Add, List, Edit -->

		<footer class="main-footer">
			<div class="float-right d-none d-sm-block-down">Anything you
				want</div>
			<strong> &nbsp; Copyright &copy; 2020 <a href="#">QL-VLXD</a>.
			</strong> All rights reserved. <br>
		</footer>
	</div>

	<%@include file="../layouts/importscript.jsp"%>

	<script type="text/javascript">
		$(function () {
			$('.currency').each(function() {
				var currency = Number($(this).text());
				$(this).text(currency.toLocaleString('vi'));
			})
		});
	
    </script>


</body>

</html>