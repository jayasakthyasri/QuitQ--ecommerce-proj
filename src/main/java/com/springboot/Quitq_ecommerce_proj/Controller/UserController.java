 package com.springboot.Quitq_ecommerce_proj.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Quitq_ecommerce_proj.Entities.User;
import com.springboot.Quitq_ecommerce_proj.Service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController  {	
	
	public UserController(UserService userservice) {
		super();
		this.userservice = userservice;
	}

	private UserService userservice;
	
	@PostMapping 
	public ResponseEntity<User> createuser(@RequestBody User user)
	{
		User saveduser = userservice.createuser(user);
		return new ResponseEntity<>(saveduser,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getuserbyid(@PathVariable("id") Long id)
	{
		User saveduser = userservice.getuserbyid(id);
		return new ResponseEntity<>(saveduser,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getalluser()
	{
		List<User> savedusers = userservice.getallUser();
		return new ResponseEntity<>(savedusers,HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id,@RequestBody User user)
	{
		User saveduser = userservice.updateuser(id, user);
		return new ResponseEntity<>(saveduser,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteuser(@PathVariable("id") Long id){
		userservice.deleteuser(id);
		return new ResponseEntity("deleted user succesfully",HttpStatus.OK);
	}
	
}
