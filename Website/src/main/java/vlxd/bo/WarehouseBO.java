package vlxd.bo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import vlxd.dto.ProductDTO;
import vlxd.dto.WarehouseDTO;
import vlxd.mapper.WarehouseMapper;

public class WarehouseBO {
	
	protected ServletContext context;

	public WarehouseBO(ServletContext context) {
		this.context = context;
	}
	
	public void createNewProductInWarehouse(Integer productId, Integer quantityInStock) {
		WarehouseMapper mapper = null;
		try {
			WarehouseDTO warehouse = new WarehouseDTO();
			ProductDTO product = new ProductDTO();
			product.setId(productId);
			warehouse.setProduct(product);
			warehouse.setQuantityInStock(quantityInStock);
			

			mapper = new WarehouseMapper();
			mapper.createNewProductInWarehouse(warehouse);

		} catch (Exception ex) {
			Logger.getLogger(WarehouseBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(WarehouseBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	public ArrayList<WarehouseDTO> listProductInWarehouse() {
		ArrayList<WarehouseDTO> listWarehouse = null;
		WarehouseMapper mapper = null;
		try {		
			mapper = new WarehouseMapper();
			listWarehouse = mapper.listProductInWarehouse();

		} catch (Exception ex) {
			Logger.getLogger(WarehouseBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(WarehouseBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
		return listWarehouse;
	}
	
	public WarehouseDTO seachWarehouseByProductId(Integer productId) {
		WarehouseDTO warehouse = null;
		WarehouseMapper mapper = null;
		try {		
			mapper = new WarehouseMapper();
			warehouse = mapper.seachWarehouseByProductId(productId);

		} catch (Exception ex) {
			Logger.getLogger(WarehouseBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(WarehouseBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
		return warehouse;
	}
	
	public void updateQuantityInStock(Integer id, Integer quantityInStock) {
		WarehouseMapper mapper = null;
		try {
			WarehouseDTO warehouse = new WarehouseDTO();
			
			warehouse.setId(id);
			warehouse.setQuantityInStock(quantityInStock);
			
			mapper = new WarehouseMapper();
			mapper.updateQuantityInStock(warehouse);

		} catch (Exception ex) {
			Logger.getLogger(WarehouseBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(WarehouseBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
