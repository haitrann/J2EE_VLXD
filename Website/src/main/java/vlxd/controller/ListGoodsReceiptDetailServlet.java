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

import vlxd.bo.GoodsReceiptDetailsBO;
import vlxd.dto.GoodsReceiptDetailsDTO;

@WebServlet(name = "ListGoodsReceiptDetailServlet", urlPatterns = { "/ListGoodsReceiptDetailServlet" })
public class ListGoodsReceiptDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = request.getSession().getServletContext();
		GoodsReceiptDetailsBO goodsReceiptDetailsBO = new GoodsReceiptDetailsBO(context);
		ArrayList<GoodsReceiptDetailsDTO> goodsReceiptDetails = new ArrayList<>();
		
		String goodsReceiptId = request.getParameter("goodsReceiptId");
		
		goodsReceiptDetails = goodsReceiptDetailsBO.showDetailsOfGoodsReceipt(Integer.valueOf(goodsReceiptId));

		request.setAttribute("goodsReceiptDetails", goodsReceiptDetails);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/transaction/StockTakeDetails.jsp");
		dispatcher.forward(request, response);
	}
}
