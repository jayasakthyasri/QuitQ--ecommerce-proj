package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.Category;
import com.springboot.Quitq_ecommerce_proj.Repositories.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	public CategoryServiceImpl(CategoryRepository categoryrepo) {
		super();
		this.categoryrepo = categoryrepo;
	}

	private CategoryRepository categoryrepo;

	@Override
	public Category createcategory(Category category) {
		// TODO Auto-generated method stub
		return categoryrepo.save(category);
	}

	@Override
	public List<Category> getallcategories() {
		// TODO Auto-generated method stub
		return categoryrepo.findAll();
	}

	@Override
	public Category getcategorybyid(Long id) {
		// TODO Auto-generated method stub
		return categoryrepo.findById(id).orElse(null);
	}

	@Override
	public Category updatecategory(Long id, Category category) {
		// TODO Auto-generated method stub
		Optional<Category> optcat = categoryrepo.findById(id);
		
		if(optcat.isPresent())
		{
			Category existingcat = optcat.get();
			existingcat.setName(category.getName());
			
			return categoryrepo.save(category);
		}
		return null;
	}

	@Override
	public void deleteCategory(Long id) {
		// TODO Auto-generated method stub
		categoryrepo.deleteById(id);
		
	}

}
