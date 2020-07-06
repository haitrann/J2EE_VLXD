package vlxd.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.CustomerBO;

@WebServlet(name = "EditCustomerServlet", urlPatterns = { "/EditCustomerServlet" })
public class EditCustomerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		ServletContext context = request.getSession().getServletContext();
		CustomerBO customerBO = new CustomerBO(context);
		customerBO.editCustomer(id, name, address, phone, email);
		
		response.sendRedirect("./ListCustomerServlet");
	}

}