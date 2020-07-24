package vlxd.dto;

import java.sql.Timestamp;

public class GoodsReceiptDTO {
	private Integer id;
	private String total;
	private String paid;
	private VendorDTO vendor;
	private UserDTO user;
	private Timestamp createdAt;
	private Integer status;
	
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
	
	public String getPaid() {
		return paid;
	}
	
	public void setPrice(String paid) {
		this.paid = paid;
	}
	
	public VendorDTO getVendor() {
		return vendor;
	}
	
	public void setVendor(VendorDTO vendor) {
		this.vendor = vendor;
	}
	
	public UserDTO getUser() {
		return user;
	}
	
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	public Timestamp getCreated_at() {
		return createdAt;
	}
	
	public void setCreated_at(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
}
