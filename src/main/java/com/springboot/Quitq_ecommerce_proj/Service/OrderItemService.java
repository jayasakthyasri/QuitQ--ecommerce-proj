package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import com.springboot.Quitq_ecommerce_proj.Entities.OrderItem;

public interface OrderItemService {
	
	OrderItem createorderitem(OrderItem orderitem);
	
	List<OrderItem> getallorderitems();
	
	OrderItem getorderitembyid(Long id);
	
	void deleteorderitembyid(Long id);

}
