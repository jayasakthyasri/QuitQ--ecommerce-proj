package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;
import java.util.Optional;

import com.springboot.Quitq_ecommerce_proj.Entities.User;
import com.springboot.Quitq_ecommerce_proj.Repositories.UserRepository;

public class UserServiceImpl implements UserService{
	
	public UserServiceImpl(UserRepository userrepo) {
		super();
		this.userrepo = userrepo;
	}

	private UserRepository userrepo;

	@Override
	public User createuser(User user) {
		// TODO Auto-generated method stub
		return userrepo.save(user);
	}

	@Override
	public List<User> getallUser() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

	@Override
	public User getuserbyid(Long id) {
		// TODO Auto-generated method stub
		return userrepo.findById(id).orElse(null);
	}

	@Override
	public User updateuser(Long id, User user) {
		// TODO Auto-generated method stub
		Optional<User> optuser = userrepo.findById(id);
		
		if(optuser.isPresent())
		{
			User existinguser = optuser.get();
			existinguser.setName(user.getName());
			existinguser.setPassword(user.getPassword());
			existinguser.setEmail(user.getEmail());
			existinguser.setContact_number(user.getContact_number());
			
			return userrepo.save(existinguser);
		}
		else
		{
			return null;
		}
	}

	@Override
	public void deleteuser(Long id) {
		// TODO Auto-generated method stub
		userrepo.deleteById(id);
		
	}

}
