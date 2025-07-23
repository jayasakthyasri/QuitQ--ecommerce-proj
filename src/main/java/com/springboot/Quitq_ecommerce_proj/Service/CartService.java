package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import com.springboot.Quitq_ecommerce_proj.Entities.Cart;

public interface CartService {
	
	Cart createcart(Cart cart);
	
	Cart getcartById(Long id);
	
	List<Cart> getallcart();
	
	void deletecartbyId(Long id);

}
