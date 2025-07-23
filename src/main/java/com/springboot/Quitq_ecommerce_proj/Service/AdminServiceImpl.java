package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.Admin;
import com.springboot.Quitq_ecommerce_proj.Repositories.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	private AdminRepository adminrepo;

	public AdminServiceImpl(AdminRepository adminrepo) {
		super();
		this.adminrepo = adminrepo;
	}

	@Override
	public Admin registerAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminrepo.save(admin);
	}

	@Override
	public Admin login(String email, String password) {
		// TODO Auto-generated method stub
		Optional<Admin> existingadmin = adminrepo.findByEmail(email);
		
		if(existingadmin.isPresent() && existingadmin.get().getPassword().equals(password))
		{
			return existingadmin.get();
		}
		else {
			
			return null;
		}
	}
	

}
