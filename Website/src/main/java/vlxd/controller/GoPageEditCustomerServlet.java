package vlxd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.CustomerBO;
import vlxd.dto.CustomerDTO;

@WebServlet(name = "GoPageEditCustomerServlet", urlPatterns = { "/GoPageEditCustomerServlet" })
public class GoPageEditCustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String currentCustomer = request.getParameter("id");

		ServletContext context = request.getSession().getServletContext();
		CustomerBO customerBO = new CustomerBO(context);
		CustomerDTO customer = new CustomerDTO();
		customer = customerBO.searchCustomerById(Integer.valueOf(currentCustomer));

		request.setAttribute("infoEditCustomer", customer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/customer/EditCustomer.jsp");
		dispatcher.forward(request, response);

	}
}