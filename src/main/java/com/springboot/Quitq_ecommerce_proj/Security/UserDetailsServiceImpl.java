package com.springboot.Quitq_ecommerce_proj.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.User;
import com.springboot.Quitq_ecommerce_proj.Repositories.UserRepository;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		
		User user = userrepo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("user not found: " +email));
		
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(),
				user.getPassword(),
				Collections.emptyList()
				);
		}
}
