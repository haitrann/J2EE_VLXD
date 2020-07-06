package vlxd.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.CategoryBO;

@WebServlet(name = "EditCategoryServlet", urlPatterns = { "/EditCategoryServlet" })
public class EditCategoryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");

		ServletContext context = request.getSession().getServletContext();
		CategoryBO categoryBO = new CategoryBO(context);
		categoryBO.editCategory(id, name);
		
		response.sendRedirect("./ListCategoryServlet");
	}

}