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

import com.springboot.Quitq_ecommerce_proj.Entities.CartItem;
import com.springboot.Quitq_ecommerce_proj.Service.CartItemService;

@RestController
@RequestMapping("/api/cartitems")
public class CartItemController {

	public CartItemController(CartItemService cartitemservice) {
		super();
		this.cartitemservice = cartitemservice;
	}

	private CartItemService cartitemservice;
	
	
	@PostMapping
	public ResponseEntity<CartItem> addcartitem(@RequestBody CartItem cartitem)
	{
		CartItem saveditem = cartitemservice.addcartItem(cartitem);
		return new ResponseEntity<>(saveditem,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CartItem>> getallcartitems()
	{
		List<CartItem> saveditems = cartitemservice.getallcartitems();
		return new ResponseEntity<>(saveditems,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CartItem> getcartitembyid(@PathVariable("id") Long id)
	{
		CartItem saveditem = cartitemservice.getcartitembyid(id);
		return new ResponseEntity<>(saveditem,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CartItem> deleteByid(@PathVariable("id") Long id)
	{
		cartitemservice.deleteCartItem(id);
		return new ResponseEntity("deleted the cartitem successfully",HttpStatus.OK);
	}
	
	
}
