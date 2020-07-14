package vlxd.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.ProductBO;

@WebServlet(name = "CreateNewProductServlet", urlPatterns = { "/CreateNewProductServlet" })
public class CreateNewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name").trim();
		String price = request.getParameter("price").trim();
		String unit = request.getParameter("unit");
		Integer category_id = Integer.valueOf(request.getParameter("category_id"));

		ServletContext context = request.getSession().getServletContext();
		ProductBO productBO = new ProductBO(context);
		productBO.createProduct(name, price, unit, category_id);

		response.sendRedirect("./ListProductServlet");
	}
}
