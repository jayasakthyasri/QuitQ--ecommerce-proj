package com.springboot.Quitq_ecommerce_proj.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Quitq_ecommerce_proj.Entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {



}
