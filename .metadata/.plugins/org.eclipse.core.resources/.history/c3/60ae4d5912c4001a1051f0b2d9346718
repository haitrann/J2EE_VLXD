package vlxd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.UserBO;
import vlxd.dto.UserDTO;
import vlxd.utility.Utils;

@WebServlet(name = "SignInAuthServlet", urlPatterns = { "/SignInAuthServlet" })
public class SignInAuthServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie cUsername = null;
		Cookie cPassword = null;

		String username = request.getParameter("username");
		String passText = request.getParameter("password");
		String password = Utils.Encrypt(passText);

		if (username == null || password == null) {
			Cookie c[] = request.getCookies();
			if (c != null) {
				username = c[1].getValue();
				password = c[2].getValue();
			}  
		}

		ServletContext context = request.getSession().getServletContext();
		UserBO userBO = new UserBO(context);
		UserDTO userLogined = userBO.loginUser(username, password);

		if (userLogined.getName() != null) {

			cUsername = new Cookie("userName", username);
			cPassword = new Cookie("userPassword", password);
			response.addCookie(cUsername);
			response.addCookie(cPassword);

			Utils.storeLoginedUser(request.getSession(), userLogined);
			response.sendRedirect("./Home");
			return;

		} else {

			String errorMessage = "Invalid Username or Password";
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/auth/SignIn.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}
}
