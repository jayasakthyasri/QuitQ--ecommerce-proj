package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import com.springboot.Quitq_ecommerce_proj.Entities.ShippingAddress;

public interface ShippingAddressService {

	ShippingAddress addshippingaddress(ShippingAddress shipadd);
	
	ShippingAddress getshippingaddressbyid(Long id);
	
	List<ShippingAddress> getAllshipadd();
	
	void deleteshipaddbyid(Long id);
	
}
