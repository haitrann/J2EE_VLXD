<%@page import="vlxd.dto.CategoryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>List Category</title>
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
							<h1 class="m-0 text-dark">List Category</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Category List</li>
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
									<h3 class="card-title">Category</h3>
								</div>


								<div class="card-body">
									<!-- <form role="form"> -->
									<div class="row">
										<div class="col-md-6 col-6">
											<a href="./GoPageCreateNewCategoryServlet">
												<Button type="button" class="btn  btn-primary float-right">Add
													New Category</Button>
											</a>
										</div>
										<div class="col-md-6 col-6">
											<!-- <a href="${pageContext.request.contextPath}/addagencydfghjk">
                                                    <Button type="button" class="btn  btn-primary float-right">Add New</Button>
                                                </a> -->
										</div>
									</div>
									<!-- </form> -->
								</div>

								<div class="card-body">
									<div class="table-responsive">
										<table id="projectTable"
											class="table table-bordered table-hover">
											<thead>
												<tr>
													<th>Id</th>
													<th>Name</th>
													<th>Edit</th>
													<th>Delete</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${categories}" var="category">
													<tr>
														<td>${category.getId()}</td>
														<td>${category.getName()}</td>
														<th><a
															href="./GoPageEditCategoryServlet?id=${category.getId()}"
															type="button" class="btn btn-outline-info">Edit</a></th>
														<th><a href="#" type="button"
															class="btn btn-outline-danger"
															onClick="deleteCategory(${category.getId()})">Delete</a></th>
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

			<!-- confirm dialog-->
			<div class="modal fade" id="confirmDeleteCategory" tabindex="-1"
				role="dialog" aria-labelledby="modelLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<form class="form" id=""
							action="./DeleteCategoryServlet"
							method="POST">
							<div class="modal-header">Confirm delete</div>
							<div id="confirmMessage" class="modal-body">Do you want to
								delete this project ?</div>
							<input type="hidden" id="categoryId" name="categoryId" value="">
							<div class="modal-footer">
								<button type="submit" id="btnDelete"
									class="btn  btn-primary btn-outline-danger">Delete</button>
								<button type="button" id="btnCancel" class="btn btn-cancel"
									data-dismiss="modal">Cancel</button>
							</div>
						</form>

					</div>
				</div>
			</div>

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
        function deleteCategory(id) {
            $('#categoryId').val(id);
            $("#confirmDeleteCategory").modal('show');
        }
    </script>


</body>

</html>