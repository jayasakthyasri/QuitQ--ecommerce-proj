package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.CartItem;
import com.springboot.Quitq_ecommerce_proj.Repositories.CartItemRepository;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	public CartItemServiceImpl(CartItemRepository cartitemrepo) {
		super();
		this.cartitemrepo = cartitemrepo;
	}

	private CartItemRepository cartitemrepo;

	
	@Override
	public CartItem addcartItem(CartItem cartitem) {
		// TODO Auto-generated method stub
		return cartitemrepo.save(cartitem);
	}

	@Override
	public List<CartItem> getallcartitems() {
		// TODO Auto-generated method stub
		return cartitemrepo.findAll();
	}

	@Override
	public CartItem getcartitembyid(Long id) {
		// TODO Auto-generated method stub
		return cartitemrepo.findById(id).orElse(null);
	}

	@Override
	public void deleteCartItem(Long id) {
		// TODO Auto-generated method stub
		cartitemrepo.deleteById(id);
		
	}

}
