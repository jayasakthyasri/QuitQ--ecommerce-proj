package com.springboot.Quitq_ecommerce_proj.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Quitq_ecommerce_proj.Entities.Cart;
import com.springboot.Quitq_ecommerce_proj.Service.CartService;


@RestController
@RequestMapping("/api/carts")
public class CartController {
	
	public CartController(CartService cartservice) {
		super();
		this.cartservice = cartservice;
	}

	private CartService cartservice;
	
	@PostMapping
	public ResponseEntity<Cart> createcart(@RequestBody Cart cart)
	{
		Cart savecart = cartservice.createcart(cart);
		return new ResponseEntity<>(savecart,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cart> getcartbyid(@PathVariable("id") Long id)
	{
		Cart savedcart = cartservice.getcartById(id);
		return new ResponseEntity<>(savedcart,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Cart>> getallcarts()
	{
		List<Cart> savedcart = cartservice.getallcart();
		return new ResponseEntity<>(savedcart,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cart> deletecartbyid(@PathVariable("id") Long id)
	{
		cartservice.deletecartbyId(id);
		return new ResponseEntity("deleted successfully",HttpStatus.OK);
	}
	
	

}
