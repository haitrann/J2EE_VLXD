package vlxd.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.VendorBO;

@WebServlet(name = "DeleteVendorServlet", urlPatterns = { "/DeleteVendorServlet" })
public class DeleteVendorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("vendorId");
		ServletContext context = request.getSession().getServletContext();
		VendorBO vendorBO = new VendorBO(context);
		vendorBO.deleteVendor(id);

		response.sendRedirect("./ListVendorServlet");
	}
}
