<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<title>Goods Receipt</title>
	<%@include file="../layouts/importstyle.jsp"%>
	<script type="text/javascript" src="https://code.jquery.com/jquery-latest.pack.js"></script>

	<style>
		.pt-3-half {
			padding-top: 1.4rem;
		}
	</style>
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
									<form id="goods-create" class="form" method="POST">
										<div class="row">
											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Vendor</label>
													<div>
														<select class="form-control" onchange="updateVendor(this)">
															<option value="">--- Choose Vendor ---</option>
															<c:forEach items="${listVendor}" var="vendor">
																<option value="${vendor.getId()}">${vendor.getName()}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<!-- /input-group -->
											</div>
											<!-- /.col-md-5 -->

											<div class="col-md-2"></div>

											<div class="col-md-5"></div>
										</div>

										<br>

										<!-- Editable table -->
										<div class="card">
											<h3 class="card-header text-center font-weight-bold text-uppercase py-4">Goods Receipt</h3>
											<input id="vendor-id" name="vendor-id" type="hidden">
											<button type="button" class="btn btn-success">
												<span id="vendor-name" name="vendor-name" class="badge badge-light">Vendor</span>
											</button>
											<div class="card-body">
												<div id="table-editable" class="table-editable">
													<span class="table-add float-right mb-3 mr-2">
														<i class="fa fa-plus fa-2x" aria-hidden="true"></i>
													</span>
													<table class="table table-bordered table-responsive-md table-striped text-center">
														<thead>
															<tr>
																<th class="text-center">Product Name</th>
																<th class="text-center">Quantity</th>
																<th class="text-center">Amount</th>
																<th class="text-center">Total</th>
																<th class="text-center">Remove</th>
															</tr>
														</thead>
														<tbody>
															
														</tbody>
													</table>
												</div>
											</div>
										</div>
										<!-- Editable table -->

										<div class="row">
											<div class="col-md-5 col-5"></div>
											<div class="col-md-2"></div>
											<div class="col-md-5 col-5">
												<h4>
													Amount payable: <span
														class="badge badge-danger ml-1" id="payment-total">0</span>
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
												<input class="form-control" id="debt" name="debt" type="text" disabled>
											</div>
										</div>

										<div class="row">
											<div class="col-md-5 col-5">
												<div class="form-group">
													<a href="">
														<button type="button"
															class="btn btn-outline-danger">Cancel</button>
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
		$(function () {
			const $tableID = $('#table-editable');
			window.data = [];
			window.paymentTotal = 0;
			window.debt = 0;
			window.vendorId = 0;
			window.paid = 0;
			
			
			$("#paid").on({
				input: function () {
					formatCurrency($(this));
				},
				blur: function () {
					updateDebt($(this).val().replace(/\./g, ''))
				}
			});
			
			$('form#goods-create').on('submit', function() {
				if (data.some(t => t.product === -1)) {
					alert('Vui long chon san pham');
					return false;
				}
				createGoodsReceipt();
			});
			
			const newTr = `<tr>
								<td class="pt-3-half">
									<select class="form-control" onchange="updateProduct(this)">
										<option value='-1'>--- Choose Product ---</option>
										<c:forEach items="${listProduct}" var="product">
											<option value="${product.getId()}">${product.getName()}</option>
										</c:forEach>
									</select>
								</td>
								<td class="pt-3-half currency" onblur="updateQuantity(this)" contenteditable="true"></td>
								<td class="pt-3-half currency" onblur="updateAmount(this)" contenteditable="true"></td>
								<td class="pt-3-half total"></td>
								<td>
									<span class="table-remove">
										<button type="button" class="btn btn-primary btn-outline-danger">Remove</button>
									</span>
								</td>
							</tr>`;

			$('.table-add').on('click', 'i', () => {
				$tableID.find('table tbody').append(newTr);
				addRowInTable();
			});
			
			$tableID.on('input', '.currency[contenteditable]', function () {
				const formattedText = formatNumber($(this).text());
				$(this).text(formattedText);
				if (formattedText.length >= 0) {
					var selection = window.getSelection();

					range = createRange(this, { count: formattedText.length });

					if (range) {
						range.collapse(false);
						selection.removeAllRanges();
						selection.addRange(range);
					}
		   		}
			});

			$tableID.on('click', '.table-remove', function () {
				const i = $(this).parents('tr').index();
				$(this).parents('tr').detach();
				removeRowInTable(i);
				updatePaymentTotal();
			});
		})

		function createRange(node, chars, range) {
		    if (!range) {
		        range = document.createRange()
		        range.selectNode(node);
		        range.setStart(node, 0);
		    }

		    if (chars.count === 0) {
		        range.setEnd(node, chars.count);
		    } else if (node && chars.count >0) {
		        if (node.nodeType === Node.TEXT_NODE) {
		            if (node.textContent.length < chars.count) {
		                chars.count -= node.textContent.length;
		            } else {
		                 range.setEnd(node, chars.count);
		                 chars.count = 0;
		            }
		        } else {
		            for (var lp = 0; lp < node.childNodes.length; lp++) {
		                range = createRange(node.childNodes[lp], chars, range);

		                if (chars.count === 0) {
		                   break;
		                }
		            }
		        }
		   } 

		   return range;
		}

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
		
		function updateVendor(t) {
			var currentOption = $(t).find('option:selected');
			$('#vendor-id').val(currentOption.val());
			vendorId = currentOption.val();
			$('#vendor-name').text(currentOption.text());
		}
		
		function addRowInTable() {
			data.push({
				product: -1,
				quantity: 0,
				amount: 0,
				total: 0
			});
		}

		function removeRowInTable(i) {
			data.splice(i, 1);
		}
		
		function updateItemAt(i, field, value, cb) {
			data[i][field] = value; //type === 'String' ? $(e).text() : window[type]($(e).text().replace(/\./g, ''));
			if (cb) cb(data[i]);
		}
		
		function updateProduct(t) {
			updateItemAt($(t).closest('tr').index(), 'product', Number($(t).find('option:selected').val()));
		}
		
		function updateQuantity(t) {
			updateItemAt($(t).parent('tr').index(), 'quantity', Number($(t).text().replace(/\./g, '')), (updatedItem) => {
				updatedItem.total = updatedItem.amount * updatedItem.quantity;
				$(t).siblings('.total').text(updatedItem.total.toLocaleString('vi'));
				updatePaymentTotal();
			})
		}
		
		function updateAmount(t) {
			updateItemAt($(t).parent('tr').index(), 'amount', Number($(t).text().replace(/\./g, '')), (updatedItem) => {
				updatedItem.total = updatedItem.amount * updatedItem.quantity;
				$(t).siblings('.total').text(updatedItem.total.toLocaleString('vi'));
				updatePaymentTotal();
			})
		};

		function updatePaymentTotal() {
			paymentTotal = data.reduce((p, c) => p + c.total, 0);
			$('#payment-total').text(paymentTotal.toLocaleString('vi'));
			updateDebt($('#paid').val().replace(/\./g, ''));
		}
		
		function updateDebt(p) {
			debt = paymentTotal - Number(p);
			$('#debt').val(debt.toLocaleString('vi'));
		}

		function createGoodsReceipt() {
			paid = $('#paid').val();
			debt = $('#debt').val();
			$.ajax({
					type: "POST",
					url: "./CreateGoodsReceivedNote",
					data: {
						products: JSON.stringify(data),
						vendorId,
						paid,
						paymentTotal,
						debt
					},
					success: function (responseText) {
						if (responseText == "fail") {
							alert("Check your input information !");
						}
					}
				})
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