package com.springboot.Quitq_ecommerce_proj.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Quitq_ecommerce_proj.Entities.Category;
import com.springboot.Quitq_ecommerce_proj.Service.CategoryService;


@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	public CategoryController(CategoryService categoryservice) {
		super();
		this.categoryservice = categoryservice;
	}

	private CategoryService categoryservice;
	
	
	@PostMapping 
	public ResponseEntity<Category> createcategory( @RequestBody Category category)
	{
		Category savedcat =  categoryservice.createcategory(category);
		return new ResponseEntity<>(savedcat,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> getallcategory()
	{
		List<Category> savedcats = categoryservice.getallcategories();
		return new ResponseEntity<>(savedcats,HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getcatbyid(@PathVariable("id") Long id)
	{
		Category savedcat = categoryservice.getcategorybyid(id);
		return new ResponseEntity<>(savedcat,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updatecategory(@PathVariable("id") Long id, Category category)
	{
		Category updatecat = categoryservice.updatecategory(id, category);
		return new ResponseEntity<>(updatecat,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Category> deletecategory(@PathVariable("id") Long id)
	{
		categoryservice.deleteCategory(id);
		return new ResponseEntity("category deleted successfully",HttpStatus.OK);
	}

}
