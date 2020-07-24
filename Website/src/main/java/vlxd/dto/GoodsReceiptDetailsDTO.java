package vlxd.dto;

public class GoodsReceiptDetailsDTO {
	private Integer id;
	private String total;
	private String unitPrice;
	private String quantity;
	private GoodsReceiptDTO goodsReceipt;
	private ProductDTO product;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTotal() {
		return total;
	}
	
	public void setName(String total) {
		this.total = total;
	}
	
	public String getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getQuantity() {
		return quantity;
	}
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public GoodsReceiptDTO getGoodsReceipt() {
		return goodsReceipt;
	}
	
	public void setGoodsReceipt(GoodsReceiptDTO goodsReceipt) {
		this.goodsReceipt = goodsReceipt;
	}
	
	public ProductDTO getProduct() {
		return product;
	}
	
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
}
