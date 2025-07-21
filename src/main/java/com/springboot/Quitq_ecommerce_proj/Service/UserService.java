package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import com.springboot.Quitq_ecommerce_proj.Entities.User;

public interface UserService {
	
	User createuser(User user);
	
	List<User> getallUser();
	
	User getuserbyid(Long id);
	
	User updateuser(Long id , User user);
	
	void deleteuser(Long id);
	
	

}
