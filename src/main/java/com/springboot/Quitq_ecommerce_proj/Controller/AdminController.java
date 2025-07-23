package com.springboot.Quitq_ecommerce_proj.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Quitq_ecommerce_proj.Entities.Admin;
import com.springboot.Quitq_ecommerce_proj.Service.AdminService;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

	private AdminService adminservice;

	public AdminController(AdminService adminservice) {
		super();
		this.adminservice = adminservice;
	}
	
	@PostMapping("/register")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin)
	{
		Admin savedadmin = adminservice.registerAdmin(admin);
		return new ResponseEntity<>(savedadmin,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginadmin(@RequestBody Admin loginrequest)
	{
		Admin admin = adminservice.login(loginrequest.getEmail(), loginrequest.getPassword());
		if(admin != null)
		{
			return new ResponseEntity<>(admin,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity("invalid email or password",HttpStatus.UNAUTHORIZED);
		}
	}
	
}
