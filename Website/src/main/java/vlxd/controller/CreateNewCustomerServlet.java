package vlxd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.CustomerBO;

@WebServlet(name = "CreateNewCustomerServlet", urlPatterns = { "/CreateNewCustomerServlet" })
public class CreateNewCustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name").trim();
		String address = request.getParameter("address").trim();
		String phone = request.getParameter("phone").trim();
		String email = request.getParameter("email").trim();
		
		ServletContext context = request.getSession().getServletContext();
		CustomerBO customerBO = new CustomerBO(context);

		if (name.length() > 0 && phone.length() > 9 && address.length() > 0) {
			customerBO.createCustomer(name, address, phone, email);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Failed to create new customer');");
			out.println("location='./GoPageCreateNewCustomerServlet';");
			out.println("</script>");
			return;
		}

		response.sendRedirect("./ListCustomerServlet");
	}
}