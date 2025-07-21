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

import com.springboot.Quitq_ecommerce_proj.Entities.Seller;
import com.springboot.Quitq_ecommerce_proj.Service.SellerService;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {
	
	public SellerController(SellerService sellerservice) {
		super();
		this.sellerservice = sellerservice;
	}

	private SellerService sellerservice;
	
	@PostMapping
	public ResponseEntity<Seller> createSeller(@RequestBody Seller seller)
	{
		Seller savedseller = sellerservice.createSeller(seller);
		return new ResponseEntity<>(savedseller,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Seller>> getallsellers()
	{
		List<Seller> savedsellers = sellerservice.getallsellers();
		return new ResponseEntity<>(savedsellers,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Seller> getsellerbyid(@PathVariable("id") Long id)
	{
		Seller savedsellers = sellerservice.getsellerbyid(id);
		return new ResponseEntity<>(savedsellers,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Seller> updateseller(@PathVariable("id") Long id, @RequestBody Seller seller)
	{
		Seller updateseller = sellerservice.updateSeller(id, seller);
		return new ResponseEntity<>(updateseller,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Seller> deleteseller(@PathVariable("id") Long id)
	{
		sellerservice.deleteSeller(id);
		return new ResponseEntity("deleted a seller successfully",HttpStatus.OK);
	}
	
	

}
