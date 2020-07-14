package vlxd.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vlxd.dto.CustomerDTO;

public class CustomerMapper extends DBMapper {
	
	public CustomerMapper() throws Exception {
		super(); // call constructor DBMapper -- get connection
	}

	public void createCustomer(CustomerDTO newCustomer) {
		try {
			String sqlStr = "INSERT into customer (name,address,phone,email) "
					+ "VALUE (?,?,?,?)";

			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);

			preparedStmt.setString(1, newCustomer.getName());
			preparedStmt.setString(2, newCustomer.getAddress());
			preparedStmt.setString(3, newCustomer.getPhone());
			preparedStmt.setString(4, newCustomer.getEmail());
			
			preparedStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<CustomerDTO> listCustomer() {
		ArrayList<CustomerDTO> customers = new ArrayList<>();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM customer";
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				CustomerDTO customer = new CustomerDTO();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setPhone(rs.getString("phone"));
				customer.setEmail(rs.getString("email"));
				customer.setCreated_at(rs.getTimestamp("created_at"));
				customer.setUpdated_at(rs.getTimestamp("updated_at"));

				
				customers.add(customer);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return customers;
	}
	
	public CustomerDTO searchCustomerById(Integer id) {
		CustomerDTO customer = new CustomerDTO();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM customer WHERE id=" + id;
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setPhone(rs.getString("phone"));
				customer.setEmail(rs.getString("email"));
				customer.setCreated_at(rs.getTimestamp("created_at"));
				customer.setUpdated_at(rs.getTimestamp("updated_at"));

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return customer;
	}

	public ArrayList<CustomerDTO> searchCustomer(String searchParameter) {
		ArrayList<CustomerDTO> customers = new ArrayList<>();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM customer "
					+ "WHERE id=trim('" + searchParameter + "') "
					+ "OR name LIKE '%" + searchParameter + "%' "
					+ "OR phone LIKE '%" + searchParameter + "%' ";
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				CustomerDTO customer = new CustomerDTO();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setPhone(rs.getString("phone"));
				customer.setEmail(rs.getString("email"));
				customer.setCreated_at(rs.getTimestamp("created_at"));
				customer.setUpdated_at(rs.getTimestamp("updated_at"));

				
				customers.add(customer);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return customers;
	}

	public void editCustomer(CustomerDTO customer) {
		try {
			String sqlStr = "UPDATE customer "
					+ "SET name=?, address=?, phone=?, email=?, updated_at=? "
					+ "WHERE id=?";
			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);

			preparedStmt.setString(1, customer.getName());
			preparedStmt.setString(2, customer.getAddress());
			preparedStmt.setString(3, customer.getPhone());
			preparedStmt.setString(4, customer.getEmail());
			preparedStmt.setTimestamp(5, customer.getUpdated_at());
			preparedStmt.setInt(6, customer.getId());

			preparedStmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

