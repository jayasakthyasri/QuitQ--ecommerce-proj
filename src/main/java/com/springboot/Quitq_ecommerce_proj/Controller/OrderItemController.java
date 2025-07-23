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

import com.springboot.Quitq_ecommerce_proj.Entities.OrderItem;
import com.springboot.Quitq_ecommerce_proj.Service.OrderItemService;


@RestController
@RequestMapping("/api/orderitems")
public class OrderItemController {
	
	private OrderItemService orderitemservice;

	public OrderItemController(OrderItemService orderitemservice) {
		super();
		this.orderitemservice = orderitemservice;
	}
	
	
	@PostMapping
	public ResponseEntity<OrderItem> createOrderitem(@RequestBody OrderItem orderitem)
	{
		OrderItem savedorderitem = orderitemservice.createorderitem(orderitem);
		return new ResponseEntity<>(savedorderitem,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderItem> getorderitembyid(@PathVariable("id") Long id)
	{
		OrderItem savedorderitem = orderitemservice.getorderitembyid(id);
		return new ResponseEntity<>(savedorderitem,HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<OrderItem>> getallorderitem()
	{
		List<OrderItem> savedorderitems = orderitemservice.getallorderitems();
		return new ResponseEntity<>(savedorderitems,HttpStatus.OK);
				
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<OrderItem> deleteorderitem(@PathVariable("id") Long id)
	{
		orderitemservice.deleteorderitembyid(id);
		return new ResponseEntity("deleted the orderitem successfully",HttpStatus.OK);
	}
	
	

}
