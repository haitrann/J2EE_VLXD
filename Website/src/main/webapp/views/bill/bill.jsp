<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Bill</title>
    <%@include file="../layouts/importstyle.jsp" %>

    <style>
        .shopping-cart-wrap .price {
            color: #007bff;
            font-size: 18px;
            font-weight: bold;
            margin-right: 5px;
            display: block;
        }

        var {
            font-style: normal;
        }

        .media img {
            margin-right: 1rem;
        }

        .img-sm {
            width: 80px !important;
            height: 80px !important;
            max-height: 75px;
            object-fit: cover;
        }

        .select-product {
            width: 400px
        }
    </style>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <%@include file="../layouts/navbar.jsp" %>
        <%@include file="../layouts/sidebar.jsp" %>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1>Bill</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="">Home</a></li>
                                <li class="breadcrumb-item active">Add</li>
                            </ol>
                        </div>
                    </div>
                </div><!-- /.container-fluid -->
            </div>

            <!-- Main content -->
            <section class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <div class="card card-primary card-outline">
                                <div class="card-header  d-flex p-0">
                                    <nav class="navbar navbar-light bg-light justify-content-between"
                                        style="background-color: transparent !important; padding-left: 1100px">
                                        <a class="navbar-brand">Customer</a>
                                        <form class="form-inline">
                                            <input class="form-control mr-sm-2" type="search" placeholder="Search"
                                                aria-label="Search">
                                            <button class="btn btn-outline-success my-2 my-sm-0"
                                                type="submit">Search</button>
                                        </form>
                                    </nav>
                                </div>

                                <div class="card-body" style="width: 100%;min-height: 100%;">
                                    <form class="form" id="" action="bill" method="POST">
                                        <div class="col">
                                            <div>
                                                <h3>Billing Address</h3>
                                            </div>
                                            <br>
                                            <div class="row">
                                                <div class="col-md-5">
                                                    <div class="form-group required">
                                                        <label class="control-label">Full Name</label>
                                                        <div>
                                                            <input id="name" name="name" type="text"
                                                                class="form-control" value="" placeholder="Hai cu to">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-5">
                                                    <div class="form-group required">
                                                        <label class="control-label">Email</label>
                                                        <div>
                                                            <input id="email" name="email" type="text"
                                                                class="form-control" maxlength="255" value=""
                                                                placeholder="haicuto@gmail.com">

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
                                                                placeholder="(08) 123 456 789">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-5">
                                                    <div class="form-group required">
                                                        <label class="control-label">Address</label>
                                                        <div>
                                                            <input id="address" name="address" type="text"
                                                                class="form-control" maxlength="255" value=""
                                                                placeholder="Le Van Viet street, Q9">

                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-10">
                                                    <div class="form-group required">
                                                        <label class="control-label">Description</label>
                                                        <div>
                                                            <input id="desciption" name="desciption" type="text"
                                                                class="form-control" maxlength="255" value=""
                                                                placeholder="Fragile, Handle with care. Please">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <hr width="40%" align="left" color="#585858"
                                            style="border-top: 2px solid rgba(0,0,0,.1);" />

                                        <div class="col">
                                            <div class="col-sm-10">
                                                <div>
                                                    <h3>Cart</h3>
                                                </div>
                                                <br>
                                                <table class="table table-hover shopping-cart-wrap"
                                                    style="border-radius: 20px;">
                                                    <thead class="thead-dark">
                                                        <tr>
                                                            <th scope="col">Product</th>
                                                            <th scope="col" width="120">Quantity</th>
                                                            <th scope="col" width="120">Price</th>
                                                            <th scope="col" width="200" class="text-right">Action</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>
                                                                <figure class="media">
                                                                    <select id="manager_id" name="manager_id"
                                                                        class="form-control select-product">
                                                                        <option></option>
                                                                        <option value="1">One</option>
                                                                        <option value="2">Two</option>
                                                                        <option value="3">Three</option>
                                                                    </select>
                                                                    <div class="img-wrap" style="padding-left: 170px;">
                                                                        <img src="http://bootstrap-ecommerce.com/main/images/items/2.jpg"
                                                                            class="img-thumbnail img-sm"></div>
                                                                </figure>
                                                            </td>
                                                            <td>
                                                                <input id="quantity" name="quantity" type="text"
                                                                    class="form-control" maxlength="255"
                                                                    style="width: 70px !important;" value=""
                                                                    placeholder="0">
                                                            </td>
                                                            <td>
                                                                <div class="price-wrap">
                                                                    <var class="price">USD 145</var>
                                                                    <small class="text-muted">(USD5 each)</small>
                                                                </div> <!-- price-wrap .// -->
                                                            </td>
                                                            <td class="text-right">
                                                                <!-- <a title="" href="" class="btn btn-outline-success"
                                                                    data-toggle="tooltip"
                                                                    data-original-title="Save to Wishlist"> <i
                                                                        class="fa fa-heart"></i></a> -->
                                                                <a href="" class="btn btn-outline-danger"> × Remove</a>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <figure class="media">
                                                                    <select id="manager_id" name="manager_id"
                                                                        class="form-control select-product">
                                                                        <option></option>
                                                                        <option value="1">One</option>
                                                                        <option value="2">Two</option>
                                                                        <option value="3">Three</option>
                                                                    </select>
                                                                    <div class="img-wrap" style="padding-left: 170px;">
                                                                        <img src="http://bootstrap-ecommerce.com/main/images/items/2.jpg"
                                                                            class="img-thumbnail img-sm"></div>
                                                                </figure>
                                                            </td>
                                                            <td>
                                                                <input id="quantity" name="quantity" type="text"
                                                                    class="form-control" maxlength="255"
                                                                    style="width: 70px !important;" value=""
                                                                    placeholder="0">
                                                            </td>
                                                            <td>
                                                                <div class="price-wrap">
                                                                    <var class="price">USD 35</var>
                                                                    <small class="text-muted">(USD10 each)</small>
                                                                </div> <!-- price-wrap .// -->
                                                            </td>
                                                            <td class="text-right">
                                                                <!-- <a title="" href="" class="btn btn-outline-success"
                                                                    data-toggle="tooltip"
                                                                    data-original-title="Save to Wishlist"> <i
                                                                        class="fa fa-heart"></i></a> -->
                                                                <a href="" class="btn btn-outline-danger btn-round"> ×
                                                                    Remove</a>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <figure class="media">
                                                                    <select id="manager_id" name="manager_id"
                                                                        class="form-control select-product">
                                                                        <option></option>
                                                                        <option value="1">One</option>
                                                                        <option value="2">Two</option>
                                                                        <option value="3">Three</option>
                                                                    </select>
                                                                    <div class="img-wrap" style="padding-left: 170px;">
                                                                        <img src="http://bootstrap-ecommerce.com/main/images/items/2.jpg"
                                                                            class="img-thumbnail img-sm"></div>
                                                                </figure>
                                                            </td>
                                                            <td>
                                                                <input id="quantity" name="quantity" type="text"
                                                                    class="form-control" maxlength="255"
                                                                    style="width: 70px !important;" value=""
                                                                    placeholder="0">
                                                            </td>
                                                            <td>
                                                                <div class="price-wrap">
                                                                    <var class="price">USD 45</var>
                                                                    <small class="text-muted">(USD15 each)</small>
                                                                </div> <!-- price-wrap .// -->
                                                            </td>
                                                            <td class="text-right">
                                                                <!-- <a title="" href="" class="btn btn-outline-success"
                                                                    data-toggle="tooltip"
                                                                    data-original-title="Save to Wishlist"> <i
                                                                        class="fa fa-heart"></i></a> -->
                                                                <a href="" class="btn btn-outline-danger btn-round"> ×
                                                                    Remove</a>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                                <div class="card-footer">
                                                    <div class="coupon col-md-5 col-sm-5 no-padding-left pull-left">
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <input type="text" class="form-control" placeholder="cupone code">
                                                            </div>
                                                            <div class="col-6">
                                                                <input type="submit" class="btn btn-default" value="Use cupone">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div>
                                                        <h4 class="text-right" style="padding: 10px 50px 10px 0;">Total
                                                        <strong>$50.00</strong></h4>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <hr width="40%" align="left" color="#585858"
                                            style="border-top: 2px solid rgba(0,0,0,.1);" />

                                        <div class="col">
                                            <div>
                                                <h3>Payment</h3>
                                            </div>
                                            <br>
                                            <div class="col-md-5">
                                                <div class="form-group required">
                                                    <label class="control-label">Payment method</label>
                                                    <div>
                                                        <select class="custom-select">
                                                            <!-- <option selected></option> -->
                                                            <option value="cash">Cash</option>
                                                            <option value="card">Card</option>
                                                            <option value="all">Both...</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
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
                            <!-- /.form -->
                        </div><!-- /.card-body -->

                    </div>
                    <!-- /.card -->
                </div>
                <!-- /.col -->
        </div>
    </div>
    </section>





    </div>


    <footer class="main-footer">
        <!-- To the right -->
        <div class="float-right d-none d-sm-block-down">
            Anything you want
        </div>
        <!-- Default to the left -->
        <strong> &nbsp; Copyright &copy; 2020 <a href="#">QL-VLXD</a>.</strong> All rights reserved.
        <br>
    </footer>
    </div>

    <%@include file="../layouts/importscript.jsp" %>

    <script type="text/javascript">

    </script>


</body>

</html>