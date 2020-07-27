package vlxd.dto;

public class WarehouseDTO {
	private Integer id;
	private ProductDTO product;
	private Integer quantityInStock;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public ProductDTO getProduct() {
		return product;
	}
	
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	
	public Integer getQuantityInStock() {
		return quantityInStock;
	}
	
	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
}
