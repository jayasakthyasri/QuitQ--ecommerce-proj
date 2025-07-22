package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import com.springboot.Quitq_ecommerce_proj.Entities.Order;

public interface OrderService {
	
	Order createorder(Order order);
	
	Order getOrderByid(Long id);
	
	List<Order> getallorders();

}
