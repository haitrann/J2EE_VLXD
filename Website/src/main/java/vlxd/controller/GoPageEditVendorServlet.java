package vlxd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.VendorBO;
import vlxd.dto.VendorDTO;

@WebServlet(name = "GoPageEditVendorServlet", urlPatterns = { "/GoPageEditVendorServlet" })
public class GoPageEditVendorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String currentVendor = request.getParameter("id");

		ServletContext context = request.getSession().getServletContext();
		VendorBO vendorBO = new VendorBO(context);
		VendorDTO vendor = new VendorDTO();
		vendor = vendorBO.searchVendorById(Integer.valueOf(currentVendor));

		request.setAttribute("infoEditVendor", vendor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/vendor/EditVendor.jsp");
		dispatcher.forward(request, response);

	}}
