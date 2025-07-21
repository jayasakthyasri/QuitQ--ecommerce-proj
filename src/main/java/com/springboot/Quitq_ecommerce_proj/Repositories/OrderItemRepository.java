package com.springboot.Quitq_ecommerce_proj.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Quitq_ecommerce_proj.Entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
