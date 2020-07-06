package vlxd.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.CategoryBO;

@WebServlet(name = "CreateNewCategoryServlet", urlPatterns = { "/CreateNewCategoryServlet" })
public class CreateNewCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name").trim();
		
		ServletContext context = request.getSession().getServletContext();
		CategoryBO categoryBO = new CategoryBO(context);
		categoryBO.createCategory(name);

		response.sendRedirect("./ListCategoryServlet");
	}
}

