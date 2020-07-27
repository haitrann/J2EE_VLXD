package vlxd.bo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import vlxd.dto.GoodsReceiptDTO;
import vlxd.dto.GoodsReceiptDetailsDTO;
import vlxd.dto.ProductDTO;
import vlxd.mapper.GoodsReceiptDetailsMapper;

public class GoodsReceiptDetailsBO {
	protected ServletContext context;

	public GoodsReceiptDetailsBO(ServletContext context) {
		this.context = context;
	}
	
	public void createGoodsReceiptDetails(String total, String unitPrice, String quantity, GoodsReceiptDTO goodsReceipt, Integer productId) {
		GoodsReceiptDetailsMapper mapper = null;
		try {
			GoodsReceiptDetailsDTO goodsReceiptDetails = new GoodsReceiptDetailsDTO();
			ProductDTO product = new ProductDTO();
			
			goodsReceiptDetails.setTotal(total);
			goodsReceiptDetails.setUnitPrice(unitPrice);
			goodsReceiptDetails.setQuantity(quantity);
			goodsReceiptDetails.setGoodsReceipt(goodsReceipt);
			product.setId(productId);
			goodsReceiptDetails.setProduct(product);

			mapper = new GoodsReceiptDetailsMapper();
			mapper.createGoodsReceiptDetails(goodsReceiptDetails);

		} catch (Exception ex) {
			Logger.getLogger(GoodsReceiptBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(GoodsReceiptBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	public ArrayList<GoodsReceiptDetailsDTO> showDetailsOfGoodsReceipt(Integer goodsReceiptId) {
		ArrayList<GoodsReceiptDetailsDTO> allDetails = new ArrayList<>();
		GoodsReceiptDetailsMapper mapper = null;
		try {
			mapper = new GoodsReceiptDetailsMapper();
			allDetails = mapper.showDetailsOfGoodsReceipt(goodsReceiptId);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return allDetails;
	}
}
