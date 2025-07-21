package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import com.springboot.Quitq_ecommerce_proj.Entities.Seller;

public interface SellerService {
	
	Seller createSeller(Seller seller);
	
	List<Seller> getallsellers();
	
	Seller getsellerbyid(Long id);
	
	Seller updateSeller(Long id,Seller seller);
	
	void deleteSeller(Long id);

}
