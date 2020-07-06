package vlxd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.CategoryBO;
import vlxd.dto.CategoryDTO;

@WebServlet(name = "GoPageEditCategoryServlet", urlPatterns = { "/GoPageEditCategoryServlet" })
public class GoPageEditCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer currentCategoryId = Integer.valueOf(request.getParameter("id"));

		ServletContext context = request.getSession().getServletContext();
		CategoryBO categoryBO = new CategoryBO(context);
		CategoryDTO category = new CategoryDTO();
		category = categoryBO.searchCategoryById(currentCategoryId).get(0);

		request.setAttribute("infoEditCategory", category);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/category/EditCategory.jsp");
		dispatcher.forward(request, response);

	}
}
