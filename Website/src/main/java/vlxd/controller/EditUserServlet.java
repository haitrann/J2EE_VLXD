package vlxd.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.UserBO;

@WebServlet(name = "EditUserServlet", urlPatterns = { "/EditUserServlet" })
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		String role = request.getParameter("role");

		ServletContext context = request.getSession().getServletContext();
		UserBO userBO = new UserBO(context);
		userBO.editUser(id, name, email, phone, role, username);

		response.sendRedirect("./ListUserServlet");
	}

}
