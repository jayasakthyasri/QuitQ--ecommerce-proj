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

import com.springboot.Quitq_ecommerce_proj.Entities.Product;
import com.springboot.Quitq_ecommerce_proj.Service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	public ProductController(ProductService productservice) {
		super();
		this.productservice = productservice;
	}

	private ProductService productservice;
	
	@PostMapping
	public ResponseEntity<Product> createproduct(@RequestBody Product prod)
	{
		Product savedprod = productservice.createProduct(prod);
		return new ResponseEntity<>(savedprod,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getallprod(@RequestBody Product prod)
	{
		List<Product> savedprod = productservice.getallProducts();
		return new ResponseEntity<>(savedprod,HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getbyid(@PathVariable("id") Long id)
	{
		Product savedprod = productservice.getById(id);
		return new ResponseEntity<>(savedprod,HttpStatus.OK);
	}

	
	@GetMapping("/sellers/{sellerId}")
	public ResponseEntity<List<Product>> getproductsbysellerid(@PathVariable("sellerId") Long sellerid)
	{
		List<Product> savedprods = productservice.getproductsBysellerid(sellerid);
		return new ResponseEntity<>(savedprods,HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProd(@PathVariable("id") Long id,@RequestBody Product prod)
	{
		Product updatingprod = productservice.updateProduct(id, prod);
		return new ResponseEntity<>(updatingprod,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteprod(@PathVariable("id") Long id)
	{
		productservice.DeleteProduct(id);
		return new ResponseEntity("Deleted the product successfully",HttpStatus.OK);
	}
}
