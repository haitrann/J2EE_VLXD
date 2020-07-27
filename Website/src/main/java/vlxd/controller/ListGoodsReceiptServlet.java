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

import vlxd.bo.GoodsReceiptBO;
import vlxd.dto.GoodsReceiptDTO;

@WebServlet(name = "ListGoodsReceiptServlet", urlPatterns = { "/ListGoodsReceiptServlet" })
public class ListGoodsReceiptServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = request.getSession().getServletContext();
		GoodsReceiptBO goodsReceiptBO = new GoodsReceiptBO(context);
		ArrayList<GoodsReceiptDTO> goodsReceipt = new ArrayList<>();
		
		goodsReceipt = goodsReceiptBO.showAllGoodsReceipt();

		request.setAttribute("goodsReceipt", goodsReceipt);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/transaction/StockTake.jsp");
		dispatcher.forward(request, response);
	}
}
