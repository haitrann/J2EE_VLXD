<!DOCTYPE html>
<html lang="en">

<head>
	<title>App</title>
    <%@include file="importstyle.jsp" %>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <%@include file="navbar.jsp" %>
        <%@include file="sidebar.jsp" %>
    <div class="content-wrapper">
    	<img style="width: 100%; height: 100%" src="${pageContext.request.contextPath}/views/public/img/heritage.jpg" width="500" height="333">
    </div>
        <aside class="control-sidebar control-sidebar-light">
        <!--
        	<a href="./GoPageLoginServlet" class="btn btn-outline-success" style="margin-left: 70px; margin-top: 30px; width: 50%;">Sign In</a>
        -->
        
            <a href="./SignOutAuthServlet" class="btn btn-outline-danger" style="margin-left: 70px; margin-top: 30px; width: 50%;">Sign Out</a>
        </aside>
        <!-- /.control-sidebar -->

        <!-- Main Footer -->
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
   
    <%@include file="importscript.jsp" %>

    <script type="text/javascript">
     
    </script>

  
</body>

</html>
