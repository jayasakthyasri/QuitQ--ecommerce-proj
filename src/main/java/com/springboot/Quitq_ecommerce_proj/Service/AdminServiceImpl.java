package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Admin registerAdmin(Admin admin) {
	    // Check if email already exists (optional)
	    if (adminrepo.findByEmail(admin.getEmail()) != null) {
	        throw new RuntimeException("Admin already exists");
	    }

	    // Hash the password before saving
	    admin.setPassword(passwordEncoder.encode(admin.getPassword()));

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
