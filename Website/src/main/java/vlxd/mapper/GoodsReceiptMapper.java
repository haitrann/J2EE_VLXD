package vlxd.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vlxd.dto.GoodsReceiptDTO;
import vlxd.dto.UserDTO;
import vlxd.dto.VendorDTO;

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
	
	public ArrayList<GoodsReceiptDTO> showAllGoodsReceipt() {
		ArrayList<GoodsReceiptDTO> allGoodsReceipt = new ArrayList<>();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT g.id,g.total,g.paid,v.name 'vendor_name',u.name 'user_name',g.created_at "
					+ "FROM vendor v, user u, goods_receipt g "
					+ "WHERE v.id=g.vendor_id and u.id=g.created_by";

			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				VendorDTO vendor = new VendorDTO();
				UserDTO user = new UserDTO();
				GoodsReceiptDTO goodsReceipt = new GoodsReceiptDTO();
				
				goodsReceipt.setId(rs.getInt("id"));
				goodsReceipt.setTotal(rs.getString("total"));
				goodsReceipt.setPaid(rs.getString("paid"));
				vendor.setName(rs.getString("vendor_name"));
				goodsReceipt.setVendor(vendor);
				user.setName(rs.getString("user_name"));
				goodsReceipt.setUser(user);
				goodsReceipt.setCreatedAt(rs.getTimestamp("created_at"));
				
				allGoodsReceipt.add(goodsReceipt);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return allGoodsReceipt;
	}
}