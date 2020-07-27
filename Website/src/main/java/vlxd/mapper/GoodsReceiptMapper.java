package vlxd.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vlxd.dto.GoodsReceiptDTO;

public class GoodsReceiptMapper extends DBMapper {

	public GoodsReceiptMapper() throws Exception {
		super(); // call constructor DBMapper -- get connection
	}

	public GoodsReceiptDTO createGoodsReceipt(GoodsReceiptDTO newGoodsReceipt) {
		GoodsReceiptDTO goodsReceipt = null;
		try {
			String sqlStr = "INSERT into goods_receipt (total,paid,vendor_id,created_by) VALUE (?,?,?,?)";

			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr, new String[] {"id"} );

			preparedStmt.setString(1, newGoodsReceipt.getTotal());
			preparedStmt.setString(2, newGoodsReceipt.getPaid());
			preparedStmt.setInt(3, newGoodsReceipt.getVendor().getId());
			preparedStmt.setInt(4, newGoodsReceipt.getUser().getId());

			preparedStmt.executeUpdate();
			
			ResultSet rs = preparedStmt.getGeneratedKeys();
			goodsReceipt = new GoodsReceiptDTO();
			while (rs != null && rs.next()) {
				goodsReceipt.setId(Integer.valueOf(rs.getString(1)));;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return goodsReceipt;
	}
}