package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.Seller;
import com.springboot.Quitq_ecommerce_proj.Repositories.SellerRepository;


@Service
public class SellerServiceImpl implements SellerService{
	
	public SellerServiceImpl(SellerRepository sellerrepo) {
		super();
		this.sellerrepo = sellerrepo;
	}

	private SellerRepository sellerrepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Seller createSeller(Seller seller) {
	    if (sellerrepo.findByEmail(seller.getEmail()) != null) {
	        throw new RuntimeException("Seller already exists");
	    }

	    seller.setPassword(passwordEncoder.encode(seller.getPassword()));
	    return sellerrepo.save(seller);
	}

	@Override
	public List<Seller> getallsellers() {
		// TODO Auto-generated method stub
		return sellerrepo.findAll();
	}

	@Override
	public Seller getsellerbyid(Long id) {
		// TODO Auto-generated method stub
		return sellerrepo.findById(id).orElse(null);
	}

	@Override
	public Seller updateSeller(Long id, Seller seller) {
		// TODO Auto-generated method stub
		Optional<Seller> optsel = sellerrepo.findById(id);
		
		if(optsel.isPresent())
		{
			Seller existingsel = optsel.get();
			existingsel.setName(seller.getName());
			existingsel.setCompany_name(seller.getCompany_name());
			existingsel.setEmail(seller.getEmail());
			existingsel.setPassword(seller.getPassword());
			
			return sellerrepo.save(existingsel);
		}
		else
		{
			return null;
		}
	}

	@Override
	public void deleteSeller(Long id) {
		// TODO Auto-generated method stub
		sellerrepo.deleteById(id);
		
	}

}
