/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.31
 * Generated at: 2020-07-13 07:55:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.auth;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SignIn_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/H:/study/school/JavaEE/website/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Website/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153359882000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1588095774186L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<title>Login</title>\r\n");
      out.write("<!-- Tell the browser to be responsive to screen width -->\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<!-- Chrome, Firefox OS and Opera -->\r\n");
      out.write("<meta name=\"theme-color\" content=\"#007bff\" />\r\n");
      out.write("<!-- Windows Phone -->\r\n");
      out.write("<meta name=\"msapplication-navbutton-color\" content=\"#007bff\">\r\n");
      out.write("<!-- iOS Safari -->\r\n");
      out.write("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"#007bff\">\r\n");
      out.write("\r\n");
      out.write("<!-- <link rel=\"icon\" href=\"{{asset('img/ducfavicon.ico')}}\" sizes=\"16x16\"> -->\r\n");
      out.write("<!-- Font Awesome Icons -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/views/public/lib/font-awesome/css/fontawesome.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/views/public/lib/font-awesome-5/css/fontawesome.min.css\">\r\n");
      out.write("<!-- Theme style -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/views/public/lib/adminlte/css/adminlte.min.css\">\r\n");
      out.write("<!-- iCheck -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/views/public/lib/iCheck/square/blue.css\">\r\n");
      out.write("<!-- Google Font: Source Sans Pro -->\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("\twidth: 360px;\r\n");
      out.write("\theight: auto;\r\n");
      out.write("\tz-index: -9999;\r\n");
      out.write("\tmargin-left: auto;\r\n");
      out.write("\tmargin-right: auto;\r\n");
      out.write("\tmargin-top: 80px;\r\n");
      out.write("\tmargin-bottom: auto;\r\n");
      out.write("}\r\n");
      out.write("canvas {\r\n");
      out.write("\tbackground-color: #e9ecef;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\tposition: fixed;\r\n");
      out.write("\ttop: 0;\r\n");
      out.write("\tleft: 0;\r\n");
      out.write("\tz-index: -9999;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- background animate -->\r\n");
      out.write("\t<!-- <canvas id=\"dot-connect\"></canvas> -->\r\n");
      out.write("\t<canvas class=\"connecting-dots\"></canvas>\r\n");
      out.write("\t<!-- /.background animate -->\r\n");
      out.write("\t<!-- Login -->\r\n");
      out.write("\t<div class=\"login-box\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"login-logo \">\r\n");
      out.write("\t\t\t<a href=\"./Home\"><b class=\"text-primary font-weight-bold\">THAI CONG INTERIOR</b></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.login-logo -->\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"card card-primary card-outline\">\r\n");
      out.write("\t\t\t<div class=\"card-header text-center\">\r\n");
      out.write("\t\t\t\t<span class=\"login-box-msg\">WELCOME</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.card-header -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"card-body login-card-body\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<form action=\"./SignInAuthServlet\" method=\"POST\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- Email -->\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"input-group mb-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group-prepend\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"input-group-text\"><i class=\"fa fa-envelope\"></i></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<input id=\"username\" type=\"Username\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"Username\" name=\"username\" value=\"\" required\r\n");
      out.write("\t\t\t\t\t\t\t\tautofocus>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- <span class=\"fa fa-envelope form-control-feedback\"></span> -->\r\n");
      out.write("\t\t\t\t\t\t\t<!-- @error('email')\r\n");
      out.write("                            <span class=\"invalid-feedback\" role=\"alert\">\r\n");
      out.write("                                <strong>{{ $message }}</strong>\r\n");
      out.write("                            </span>\r\n");
      out.write("                            @enderror -->\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- Password -->\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"input-group mb-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group-prepend\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"input-group-text\"><i class=\"fa fa-lock\"></i></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<input id=\"password\" type=\"password\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"Password\" name=\"password\">\r\n");
      out.write("\t\t\t\t\t\t\t<!-- <span class=\"fa fa-lock form-control-feedback\"></span> -->\r\n");
      out.write("\t\t\t\t\t\t\t<!-- @error('password')\r\n");
      out.write("                            <span class=\"invalid-feedback\" role=\"alert\">\r\n");
      out.write("                                <strong>{{ $message }}</strong>\r\n");
      out.write("                            </span>\r\n");
      out.write("                            @enderror -->\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- /.Password -->\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<span id='errorMessage' class=\"badge badge-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMessage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- Sign in -->\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-8\"></div>\r\n");
      out.write("\t\t\t\t\t\t<!-- /.col -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-4\">\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary btn-block btn-flat\">LOGIN</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- /.col -->\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- /.Sign-in -->\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<p class=\"mb-0\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">Forgot password ?</a>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<p class=\"mb-1\">\r\n");
      out.write("\t\t\t\t\t<a href=\"AddUser\">Create new account</a>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.login-card-body -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- <div class=\"card-footer\"></div> -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- /.login-box -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- jQuery -->\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/views/public/lib/jquery/jquery.min.js\"></script>\r\n");
      out.write("\t<!-- Bootstrap 4 -->\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/views/public/lib/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\t<!-- iCheck -->\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/views/public/lib/iCheck/icheck.min.js\"></script>\r\n");
      out.write("\t<!-- dot-connect -->\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/views/public/lib/canvas-animation/dot-connect.js\"></script>\r\n");
      out.write("\t<!-- <script src=\"{{asset('lib/canvas-animation/dot-connect.min.js')}}\"></script> -->\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t// $(function() {\r\n");
      out.write("\t\t//     $('input').iCheck({\r\n");
      out.write("\t\t//         checkboxClass: 'icheckbox_square-blue',\r\n");
      out.write("\t\t//         radioClass: 'iradio_square-blue',\r\n");
      out.write("\t\t//         increaseArea: '20%' // optional\r\n");
      out.write("\t\t//     })\r\n");
      out.write("\t\t// })\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}