package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import com.springboot.Quitq_ecommerce_proj.Entities.Review;

public interface ReviewService {
	
	Review createreview(Review review);
	
	Review getReviewByid(Long id);
	
	List<Review> getAllreview();
	
	List<Review> getreviewsByProductId(Long productId);
	
	List<Review> getreviewByUserId(Long userId);
	
	void deleteReview(Long id);

}
