package vlxd.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.UserBO;

@WebServlet(name = "DeleteUserServlet", urlPatterns = { "/DeleteUserServlet" })
public class DeleteUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("userId");
		ServletContext context = request.getSession().getServletContext();
		UserBO userBO = new UserBO(context);
		userBO.deteleUser(id);

		response.sendRedirect("./ListUserServlet");
	}
}
