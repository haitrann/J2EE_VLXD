package vlxd.bo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import vlxd.dto.GoodsReceiptDTO;
import vlxd.dto.UserDTO;
import vlxd.dto.VendorDTO;
import vlxd.mapper.GoodsReceiptMapper;

public class GoodsReceiptBO {
	
	protected ServletContext context;

	public GoodsReceiptBO(ServletContext context) {
		this.context = context;
	}
	
	public GoodsReceiptDTO createGoodsReceipt(String total, String paid, Integer vendorId, Integer userId) {
		GoodsReceiptDTO setInsertedId = null;
		GoodsReceiptMapper mapper = null;
		try {
			GoodsReceiptDTO goodsReceipt = new GoodsReceiptDTO();
			VendorDTO vendor = new VendorDTO();
			UserDTO user = new UserDTO();
			
			goodsReceipt.setTotal(total);
			goodsReceipt.setPaid(paid);
			vendor.setId(vendorId);
			goodsReceipt.setVendor(vendor);
			user.setId(userId);
			goodsReceipt.setUser(user);
			

			mapper = new GoodsReceiptMapper();
			setInsertedId = new GoodsReceiptDTO();
			setInsertedId = mapper.createGoodsReceipt(goodsReceipt);

		} catch (Exception ex) {
			Logger.getLogger(GoodsReceiptBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(GoodsReceiptBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
		return setInsertedId;
	}
	
	public ArrayList<GoodsReceiptDTO> showAllGoodsReceipt() {
		ArrayList<GoodsReceiptDTO> allGoodsReceipt = null;
		GoodsReceiptMapper mapper = null;
		try {
			mapper = new GoodsReceiptMapper();
			allGoodsReceipt = mapper.showAllGoodsReceipt();

		} catch (Exception ex) {
			Logger.getLogger(GoodsReceiptBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(GoodsReceiptBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
		return allGoodsReceipt;
	}
	
}
