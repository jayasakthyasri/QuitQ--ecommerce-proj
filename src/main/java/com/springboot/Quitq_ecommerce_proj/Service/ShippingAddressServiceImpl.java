package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.ShippingAddress;
import com.springboot.Quitq_ecommerce_proj.Repositories.ShippingAddressRepository;


@Service
public class ShippingAddressServiceImpl implements ShippingAddressService{
	
	public ShippingAddressServiceImpl(ShippingAddressRepository shipaddrepo) {
		super();
		this.shipaddrepo = shipaddrepo;
	}

	private ShippingAddressRepository shipaddrepo;

	@Override
	public ShippingAddress addshippingaddress(ShippingAddress shipadd) {
		// TODO Auto-generated method stub
		return shipaddrepo.save(shipadd);
	}

	@Override
	public ShippingAddress getshippingaddressbyid(Long id) {
		// TODO Auto-generated method stub
		return shipaddrepo.findById(id).orElse(null);
	}

	@Override
	public List<ShippingAddress> getAllshipadd() {
		// TODO Auto-generated method stub
		return shipaddrepo.findAll();
	}

	@Override
	public void deleteshipaddbyid(Long id) {
		// TODO Auto-generated method stub
		shipaddrepo.deleteById(id);
	}
	

}
