package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.Order;
import com.springboot.Quitq_ecommerce_proj.Repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	private OrderRepository orderrepo;
	
	public OrderServiceImpl(OrderRepository orderrepo) {
		super();
		this.orderrepo = orderrepo;
	}

	@Override
	public Order createorder(Order order) {
		// TODO Auto-generated method stub
		return orderrepo.save(order);
	}

	@Override
	public Order getOrderByid(Long id) {
		// TODO Auto-generated method stub
		return orderrepo.findById(id).orElse(null);
	}

	@Override
	public List<Order> getallorders() {
		// TODO Auto-generated method stub
		return orderrepo.findAll();
	}

	
	

}
