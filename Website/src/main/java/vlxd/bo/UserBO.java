package vlxd.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import vlxd.dto.UserDTO;
import vlxd.mapper.UserMapper;

public class UserBO {
	protected ServletContext context;

	public UserBO(ServletContext context) {
		this.context = context;
	}

	public UserDTO loginUser(String username, String password) {
		UserDTO userLogined = new UserDTO();
		UserMapper mapper = null;
		try {
			UserDTO user = new UserDTO();
			user.setUsername(username);
			user.setPassword(password);

			mapper = new UserMapper();
			userLogined = mapper.loginUser(user);

		} catch (Exception e) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception e) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return userLogined;
	}
	
	public ArrayList<UserDTO> checkUserAvailable(String username) {
		ArrayList<UserDTO> users = new ArrayList<>();
		UserMapper mapper = null;
		try {
			mapper = new UserMapper();
			users = mapper.checkUserAvailable(username);

		} catch (Exception e) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception e) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return users;
	}

	public void createUser(String name, String email, String phone, String username, String role, String password) {
		UserMapper mapper = null;
		try {
			UserDTO user = new UserDTO();
			user.setName(name);
			user.setEmail(email);
			user.setPhone(phone);
			user.setUsername(username);
			user.setPassword(password);
			user.setRole(role);

			mapper = new UserMapper();
			mapper.createUser(user);

		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public ArrayList<UserDTO> listUser() {
		ArrayList<UserDTO> users = null;
		UserMapper mapper = null;
		try {
			mapper = new UserMapper();
			users = mapper.listUser();
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return users;
	}

	public ArrayList<UserDTO> searchUserById(Integer id) {
		ArrayList<UserDTO> users = null;
		UserMapper mapper = null;
		try {
			mapper = new UserMapper();
			users = mapper.searchUserById(id);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return users;
	}

	public ArrayList<UserDTO> searchUserByName(String name) {
		ArrayList<UserDTO> users = null;
		UserMapper mapper = null;
		try {
			mapper = new UserMapper();
			users = mapper.searchUserByName(name);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return users;
	}

	public void editUser(String id, String name, String email, String phone, String role, String username) {
		UserMapper mapper = null;
		try {
			UserDTO user = new UserDTO();
			user.setId(Integer.valueOf(id));
			user.setName(name);
			user.setEmail(email);
			user.setPhone(phone);
			user.setRole(role);
			user.setUsername(username);
			Timestamp update_at = new Timestamp(System.currentTimeMillis());
			user.setUpdated_at(update_at);
			mapper = new UserMapper();
			mapper.editUser(user);

		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public void deteleUser(String id) {
		UserMapper mapper = null;
		try {
			UserDTO user = new UserDTO();
			user.setId(Integer.valueOf(id));
			Timestamp update_at = new Timestamp(System.currentTimeMillis());
			user.setUpdated_at(update_at);
			mapper = new UserMapper();
			mapper.deleteUser(user);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
