package com.springboot.Quitq_ecommerce_proj.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.Quitq_ecommerce_proj.Entities.Seller;

public interface SellerRepository extends JpaRepository<Seller,Long>
{
	Seller findByEmail(String email);
}
