package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.Cart;
import com.springboot.Quitq_ecommerce_proj.Repositories.CartRepository;


@Service
public class CartServiceImpl implements CartService {
	
	public CartServiceImpl(CartRepository cartrepo) {
		super();
		this.cartrepo = cartrepo;
	}

	private CartRepository cartrepo;

	@Override
	public Cart createcart(Cart cart) {
		// TODO Auto-generated method stub
		return cartrepo.save(cart);
	}

	@Override
	public Cart getcartById(Long id) {
		// TODO Auto-generated method stub
		return cartrepo.findById(id).orElse(null);
	}

	@Override
	public List<Cart> getallcart() {
		// TODO Auto-generated method stub
		return cartrepo.findAll();
	}

	@Override
	public void deletecartbyId(Long id) {
		// TODO Auto-generated method stub
		cartrepo.deleteById(id);
	}
	
	
}
