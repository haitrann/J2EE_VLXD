package vlxd.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import vlxd.dto.WarehouseDTO;

public class WarehouseMapper extends DBMapper {

	public WarehouseMapper() throws Exception {
		super(); // call constructor DBMapper -- get connection
	}

	public void createNewProductInWarehouse(WarehouseDTO warehouse) {
		try {
			String sqlStr = "INSERT into warehouse (product_id,quantity_in_stock) VALUE (?,?)";

			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);

			preparedStmt.setInt(1, warehouse.getProductId());
			preparedStmt.setInt(2, warehouse.getQuantityInStock());
			preparedStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public WarehouseDTO seachWarehouseByProductId(Integer productId) {
		WarehouseDTO warehouse = new WarehouseDTO();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM warehouse "
					+ "WHERE product_id=" + productId;
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				warehouse.setId(rs.getInt("id"));
				warehouse.setProductId(rs.getInt("product_id"));
				warehouse.setQuantityInStock(rs.getInt("quantity_in_stock"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return warehouse;
	}
	
	public void updateQuantityInStock(WarehouseDTO warehouse) {
		try {
			String sqlStr = "UPDATE warehouse "
					+ "SET quantity_in_stock=? "
					+ "WHERE id=?";
			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);

			preparedStmt.setInt(1, warehouse.getQuantityInStock());
			preparedStmt.setInt(2, warehouse.getId());

			preparedStmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
