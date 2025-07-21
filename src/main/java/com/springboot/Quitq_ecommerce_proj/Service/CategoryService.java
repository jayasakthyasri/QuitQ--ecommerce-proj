package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import com.springboot.Quitq_ecommerce_proj.Entities.Category;

public interface CategoryService {
	
	Category createcategory(Category category);
	
	List<Category> getallcategories();
	
	Category getcategorybyid(Long id);
	
	Category updatecategory(Long id, Category category);
	
	void deleteCategory(Long id);

}
