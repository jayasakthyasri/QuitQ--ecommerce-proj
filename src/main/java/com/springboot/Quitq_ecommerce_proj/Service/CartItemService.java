package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import com.springboot.Quitq_ecommerce_proj.Entities.CartItem;

public interface CartItemService {
	
	CartItem addcartItem(CartItem cartitem);
	
	List<CartItem> getallcartitems();
	
	CartItem getcartitembyid(Long id);
	
	void deleteCartItem(Long id);
	

}
