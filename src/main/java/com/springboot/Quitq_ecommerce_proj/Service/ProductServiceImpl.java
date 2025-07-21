package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.Product;
import com.springboot.Quitq_ecommerce_proj.Repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productrepo;
	
	public ProductServiceImpl(ProductRepository productrepo) {
		super();
		this.productrepo = productrepo;
	}

	

	@Override
	public Product createProduct(Product prod) {
		// TODO Auto-generated method stub
		
		return productrepo.save(prod);
		
	}

	@Override
	public Product getById(Long id) {
		// TODO Auto-generated method stub
		return productrepo.findById(id).orElse(null);
	}

	@Override
	public List<Product> getallProducts() {
		// TODO Auto-generated method stub
		return productrepo.findAll();
	}

	@Override
	public Product updateProduct(Long id, Product prod) {
		// TODO Auto-generated method stub
		Optional<Product> optprod = productrepo.findById(id);
		
		if(optprod.isPresent())
		{
			Product existingprod = optprod.get();
			existingprod.setName(prod.getName());
			existingprod.setPrice(prod.getPrice());
			existingprod.setCategory_id(prod.getCategory_id());
			existingprod.setDescription(prod.getDescription());
			existingprod.setSeller_id(prod.getSeller_id());
			existingprod.setStock(prod.getStock());
			
			return productrepo.save(existingprod);
		}
		else {
			
			return null;
		}
	}

	@Override
	public void DeleteProduct(Long id) {
		// TODO Auto-generated method stub
		
		productrepo.deleteById(id);
		
		
	}
	

}
