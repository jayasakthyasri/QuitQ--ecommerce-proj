package com.springboot.Quitq_ecommerce_proj.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Quitq_ecommerce_proj.Entities.Review;

public interface ReviewRepository extends JpaRepository<Review,Long> {
	
	List<Review> findByProduct_Id(Long product_Id);
	List<Review> findByUser_Id(Long User_Id);

}
