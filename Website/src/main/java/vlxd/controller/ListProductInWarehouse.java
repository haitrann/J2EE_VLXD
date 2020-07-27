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

import vlxd.bo.WarehouseBO;
import vlxd.dto.WarehouseDTO;

@WebServlet(name = "ListProductInWarehouse", urlPatterns = { "/ListProductInWarehouse" })
public class ListProductInWarehouse extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = request.getSession().getServletContext();
		WarehouseBO warehouseBO = new WarehouseBO(context);
		ArrayList<WarehouseDTO> listWarehouse = new ArrayList<>();

		listWarehouse = warehouseBO.listProductInWarehouse();
		System.out.print(listWarehouse);
		request.setAttribute("listWarehouse", listWarehouse);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/warehouse/Warehouse.jsp");
		dispatcher.forward(request, response);
	}
}
