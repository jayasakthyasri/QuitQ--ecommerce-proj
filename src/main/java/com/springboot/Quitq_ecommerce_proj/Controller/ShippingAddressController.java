package com.springboot.Quitq_ecommerce_proj.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Quitq_ecommerce_proj.Entities.ShippingAddress;
import com.springboot.Quitq_ecommerce_proj.Service.ShippingAddressService;

@RestController
@RequestMapping("/api/shippingaddress")
public class ShippingAddressController {
	
	public ShippingAddressController(ShippingAddressService shipaddservice) {
		super();
		this.shipaddservice = shipaddservice;
	}

	private ShippingAddressService shipaddservice;

	@PostMapping
	public ResponseEntity<ShippingAddress> addshipadd(@RequestBody ShippingAddress shipadd)
	{
		ShippingAddress savedadd = shipaddservice.addshippingaddress(shipadd);
		return new ResponseEntity<>(savedadd,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ShippingAddress> getshipaddbyid(@PathVariable("id") Long id)
	{
		ShippingAddress savedadd = shipaddservice.getshippingaddressbyid(id);
		return new ResponseEntity<>(savedadd,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ShippingAddress>> getallshipadd()
	{
		List<ShippingAddress> savedadds = shipaddservice.getAllshipadd();
		return new ResponseEntity<>(savedadds,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ShippingAddress> deleteshipadd(@PathVariable("id") Long id)
	{
		shipaddservice.deleteshipaddbyid(id);
		return new ResponseEntity("deleted the shippingaddress successfully",HttpStatus.OK);
	}
	
}
