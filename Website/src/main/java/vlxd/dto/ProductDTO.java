package vlxd.dto;

public class ProductDTO {
	private Integer id;
	private String name;
	private String price;
	private String unit;
	private CategoryDTO category;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public CategoryDTO getCategory() {
		return category;
	}
	
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	
}
