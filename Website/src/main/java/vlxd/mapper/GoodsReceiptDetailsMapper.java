package vlxd.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vlxd.dto.GoodsReceiptDTO;
import vlxd.dto.GoodsReceiptDetailsDTO;
import vlxd.dto.ProductDTO;

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
	
	public ArrayList<GoodsReceiptDetailsDTO> showDetailsOfGoodsReceipt(Integer goodsReceiptId) {
		ArrayList<GoodsReceiptDetailsDTO> allDetails = new ArrayList<>();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT gd.id, gd.total, gd.unit_price, gd.quantity, g.id 'goods_receipt_id', p.name 'product_name' "
					+ "FROM goods_receipt g, goods_receipt_details gd, product p "
					+ "WHERE g.id=gd.goods_receipt_id AND p.id=gd.product_id AND g.id=" + goodsReceiptId;

			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				GoodsReceiptDTO goodsReceipt = new GoodsReceiptDTO();
				ProductDTO product = new ProductDTO();
				GoodsReceiptDetailsDTO goodsReceiptDetails = new GoodsReceiptDetailsDTO();
				
				goodsReceiptDetails.setId(rs.getInt("id"));
				goodsReceiptDetails.setTotal(rs.getString("total"));
				goodsReceiptDetails.setUnitPrice(rs.getString("unit_price"));
				goodsReceiptDetails.setQuantity(String.valueOf(rs.getInt("quantity")));
				
				goodsReceipt.setId(rs.getInt("goods_receipt_id"));
				goodsReceiptDetails.setGoodsReceipt(goodsReceipt);
				product.setName(rs.getString("product_name"));
				goodsReceiptDetails.setProduct(product);
				
				allDetails.add(goodsReceiptDetails);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return allDetails;
	}

}
