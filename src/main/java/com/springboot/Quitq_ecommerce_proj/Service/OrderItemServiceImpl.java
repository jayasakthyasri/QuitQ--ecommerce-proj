package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.OrderItem;
import com.springboot.Quitq_ecommerce_proj.Repositories.OrderItemRepository;


@Service
public class OrderItemServiceImpl implements OrderItemService{
	
	public OrderItemServiceImpl(OrderItemRepository orderItemrepo) {
		super();
		OrderItemrepo = orderItemrepo;
	}

	private OrderItemRepository OrderItemrepo;

	@Override
	public OrderItem createorderitem(OrderItem orderitem) {
		// TODO Auto-generated method stub
		return OrderItemrepo.save(orderitem);
	}

	@Override
	public List<OrderItem> getallorderitems() {
		// TODO Auto-generated method stub
		return OrderItemrepo.findAll();
	}

	@Override
	public OrderItem getorderitembyid(Long id) {
		// TODO Auto-generated method stub
		return OrderItemrepo.findById(id).orElse(null);
	}

	@Override
	public void deleteorderitembyid(Long id) {
		// TODO Auto-generated method stub
		OrderItemrepo.deleteById(id);
		
	}
	
	

}
