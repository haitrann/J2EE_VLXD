package vlxd.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.UserBO;
import vlxd.dto.UserDTO;

@WebServlet(name = "CheckUsernameAvailableServlet", urlPatterns = { "/CheckUsernameAvailableServlet" })
public class CheckUsernameAvailableServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("usernameInput");
		
		ServletContext context = request.getSession().getServletContext();
		UserBO userBO = new UserBO(context);
		ArrayList<UserDTO> userCheck = userBO.checkUserAvailable(username);
		
		if (userCheck.isEmpty() == false) {
			response.setContentType("text/plain");
			response.getWriter().write("The username is not valid");
		} else {
			response.setContentType("text/plain");
			response.getWriter().write("The username is valid");
		}
	
	}
	
}
