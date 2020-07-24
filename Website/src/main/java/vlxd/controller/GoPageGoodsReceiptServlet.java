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

import vlxd.bo.ProductBO;
import vlxd.dto.ProductDTO;

@WebServlet(name = "GoPageGoodsReceiptServlet", urlPatterns = { "/GoPageGoodsReceiptServlet" })
public class GoPageGoodsReceiptServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = request.getSession().getServletContext();
		ProductBO productBO = new ProductBO(context);
		ArrayList<ProductDTO> product = new ArrayList<>();
		product = productBO.listProduct();
		
		request.setAttribute("listProduct", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/transaction/GoodsReceipt.jsp");
		dispatcher.forward(request, response);
	}
}
