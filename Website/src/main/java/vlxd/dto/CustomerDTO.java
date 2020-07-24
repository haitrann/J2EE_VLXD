package vlxd.dto;

import java.sql.Timestamp;

public class CustomerDTO {
	private Integer id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
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
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Timestamp getCreated_at() {
		return createdAt;
	}
	
	public void setCreated_at(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	public Timestamp getUpdated_at() {
		return updatedAt;
	}
	
	public void setUpdated_at(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}


