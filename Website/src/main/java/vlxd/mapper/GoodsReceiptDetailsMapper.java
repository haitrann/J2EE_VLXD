package vlxd.mapper;

import java.sql.PreparedStatement;

import vlxd.dto.GoodsReceiptDetailsDTO;

public class GoodsReceiptDetailsMapper extends DBMapper {

	public GoodsReceiptDetailsMapper() throws Exception {
		super(); // call constructor DBMapper -- get connection
	}

	public void createGoodsReceiptDetails(GoodsReceiptDetailsDTO newGoodsReceiptDetails) {
		try {
			String sqlStr = "INSERT into goods_receipt_details (total,unit_price,quantity,goods_receipt_id,product_id) VALUE (?,?,?,?,?)";

			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);

			preparedStmt.setString(1, newGoodsReceiptDetails.getTotal());
			preparedStmt.setString(2, newGoodsReceiptDetails.getUnitPrice());
			preparedStmt.setString(3, newGoodsReceiptDetails.getQuantity());
			preparedStmt.setInt(4, newGoodsReceiptDetails.getGoodsReceipt().getId());
			preparedStmt.setInt(5, newGoodsReceiptDetails.getProduct().getId());
			
			preparedStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
