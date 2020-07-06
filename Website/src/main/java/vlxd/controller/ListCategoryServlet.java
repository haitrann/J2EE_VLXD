package vlxd.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.CategoryBO;
import vlxd.dto.CategoryDTO;

@WebServlet(name = "ListCategoryServlet", urlPatterns = { "/ListCategoryServlet" })
public class ListCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = request.getSession().getServletContext();
		CategoryBO categoryBO = new CategoryBO(context);
		ArrayList<CategoryDTO> categories = new ArrayList<>();

		categories = categoryBO.listCategory();

		request.setAttribute("categories", categories);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/category/ListCategory.jsp");
		dispatcher.forward(request, response);
	}
}
