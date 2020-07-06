package vlxd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.UserBO;
import vlxd.dto.UserDTO;
import vlxd.utility.Utils;

@WebServlet(name = "CreateNewUserServlet", urlPatterns = { "/CreateNewUserServlet" })
public class CreateNewUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();
		String phone = request.getParameter("phone").trim();
		String username = request.getParameter("username").trim();
		String role = request.getParameter("role").trim();
		String passText = request.getParameter("password").trim();
		String confirmPassword = request.getParameter("confirm_password").trim();

		ServletContext context = request.getSession().getServletContext();
		UserBO userBO = new UserBO(context);
		ArrayList<UserDTO> userCheck = userBO.checkUserAvailable(username);

		if (confirmPassword.equals(passText) == true && userCheck.isEmpty() == true && username.length() >= 6
				&& name.length() > 0 && phone.length() > 9 && role.length() > 0) {
			String password = Utils.Encrypt(passText);
			userBO.createUser(name, email, phone, username, role, password);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Failed to create new user');");
			out.println("location='./GoPageCreateNewUserServlet';");
			out.println("</script>");
			return;
		}

		response.sendRedirect("./ListUserServlet");
	}
}
