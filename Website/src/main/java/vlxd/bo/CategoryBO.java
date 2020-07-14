package vlxd.bo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import vlxd.dto.CategoryDTO;
import vlxd.mapper.CategoryMapper;

public class CategoryBO {
	protected ServletContext context;

	public CategoryBO(ServletContext context) {
		this.context = context;
	}
	
	public void createCategory(String name) {
		CategoryMapper mapper = null;
		try {
			CategoryDTO category = new CategoryDTO();
			category.setName(name);

			mapper = new CategoryMapper();
			mapper.createCategory(category);

		} catch (Exception ex) {
			Logger.getLogger(CategoryBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(CategoryBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public ArrayList<CategoryDTO> listCategory() {
		ArrayList<CategoryDTO> categories = null;
		CategoryMapper mapper = null;
		try {
			mapper = new CategoryMapper();
			categories = mapper.listCategory();
		} catch (Exception ex) {
			Logger.getLogger(CategoryBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(CategoryBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return categories;
	}
	
	public CategoryDTO searchCategoryById(Integer id) {
		CategoryDTO category = null;
		CategoryMapper mapper = null;
		try {
			mapper = new CategoryMapper();
			category = mapper.searchCategoryById(id);
		} catch (Exception ex) {
			Logger.getLogger(CategoryBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(CategoryBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return category;
	}
	
	public void editCategory(String id, String name) {
		CategoryMapper mapper = null;
		try {
			CategoryDTO category = new CategoryDTO();
			category.setId(Integer.valueOf(id));
			category.setName(name);
			
			mapper = new CategoryMapper();
			mapper.editCategory(category);;

		} catch (Exception ex) {
			Logger.getLogger(CategoryBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(CategoryBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public void deteleCategory(String id) {
		CategoryMapper mapper = null;
		try {
			CategoryDTO category = new CategoryDTO();
			category.setId(Integer.valueOf(id));

			mapper = new CategoryMapper();
			mapper.deleteCategory(category);
		} catch (Exception ex) {
			Logger.getLogger(CategoryBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(CategoryBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
