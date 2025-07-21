package com.springboot.Quitq_ecommerce_proj.Service;



import java.util.List;

import com.springboot.Quitq_ecommerce_proj.Entities.Product;

public interface ProductService {
	
	Product createProduct(Product prod);
	
	Product getById(Long id);
	
	List<Product> getallProducts();
	
	Product updateProduct(Long id,Product prod);
	
	void DeleteProduct(Long id);
	
}
