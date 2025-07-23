package com.springboot.Quitq_ecommerce_proj.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.Admin;

public interface AdminService {
	
	Admin registerAdmin(Admin admin);
	
	Admin login(String email,String password);

}
