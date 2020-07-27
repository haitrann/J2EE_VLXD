package vlxd.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import vlxd.bo.GoodsReceiptBO;
import vlxd.bo.GoodsReceiptDetailsBO;
import vlxd.bo.VendorBO;
import vlxd.dto.GoodsReceiptDTO;
import vlxd.dto.UserDTO;
import vlxd.utility.Utils;

@WebServlet(name = "CreateGoodsReceivedNote", urlPatterns = { "/CreateGoodsReceivedNote" })
public class CreateGoodsReceivedNote extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paymentTotal = request.getParameter("paymentTotal");
		String vendorId = request.getParameter("vendorId");
		String paid = Utils.formatStringWithoutDot(request.getParameter("paid"));
		String jsonArrayProducts = request.getParameter("products");
		String debt = Utils.formatStringWithoutDot(request.getParameter("debt"));
		UserDTO loginedUser = Utils.getLoginedUser(request.getSession());
		Integer userId = loginedUser.getId();
		
		ServletContext context = request.getSession().getServletContext();
		GoodsReceiptBO goodsReceiptBO = new GoodsReceiptBO(context);
		GoodsReceiptDetailsBO goodsReceiptDetailsBO = new GoodsReceiptDetailsBO(context);
		VendorBO vendor = new VendorBO(context);
		GoodsReceiptDTO goodsReceipt = goodsReceiptBO.createGoodsReceipt(paymentTotal, paid, Integer.valueOf(vendorId), userId);
		
		JSONArray jsonArray = new JSONArray(jsonArrayProducts);
		
		for (int i = 0; i < jsonArray.length(); i++) {
			String total = String.valueOf(jsonArray.getJSONObject(i).getInt("total"));
			String unitPrice = String.valueOf(jsonArray.getJSONObject(i).getInt("amount"));
			String quantity = String.valueOf(jsonArray.getJSONObject(i).getInt("quantity"));
			Integer productId = jsonArray.getJSONObject(i).getInt("product");
			goodsReceiptDetailsBO.createGoodsReceiptDetails(total, unitPrice, quantity, goodsReceipt, productId);
		}
		
		String currentDebtOfVendor =  (vendor.searchVendorById(Integer.valueOf(vendorId))).getDebt();
		
		String newDebt = String.valueOf(Integer.valueOf(currentDebtOfVendor) + Integer.valueOf(debt));
		
		vendor.updateDebtOfVendor(vendorId, newDebt);
		
		response.sendRedirect("./ListCategoryServlet");
	}
}