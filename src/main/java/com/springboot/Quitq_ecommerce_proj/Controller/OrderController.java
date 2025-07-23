package com.springboot.Quitq_ecommerce_proj.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Quitq_ecommerce_proj.Entities.Order;
import com.springboot.Quitq_ecommerce_proj.Service.OrderService;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
	public OrderController(OrderService orderservice) {
		super();
		this.orderservice = orderservice;
	}

	private OrderService orderservice;
	
	@PostMapping
	public ResponseEntity<Order> createorder(@RequestBody Order order)
	{
		Order savedorder = orderservice.createorder(order);
		return new ResponseEntity<>(savedorder,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getordeByid(@PathVariable("id") Long id)
	{
		Order savedorder = orderservice.getOrderByid(id);
		return new ResponseEntity<>(savedorder,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getallorders()
	{
		List<Order> savedorders = orderservice.getallorders();
		return new ResponseEntity<>(savedorders,HttpStatus.OK);
	}

}
