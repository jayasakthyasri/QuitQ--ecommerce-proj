package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.Review;
import com.springboot.Quitq_ecommerce_proj.Repositories.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	public ReviewServiceImpl(ReviewRepository reviewrepo) {
		super();
		this.reviewrepo = reviewrepo;
	}

	private ReviewRepository reviewrepo;

	@Override
	public Review createreview(Review review) {
		// TODO Auto-generated method stub
		return reviewrepo.save(review);
	}

	@Override
	public Review getReviewByid(Long id) {
		// TODO Auto-generated method stub
		return reviewrepo.findById(id).orElse(null);
	}

	@Override
	public List<Review> getAllreview() {
		// TODO Auto-generated method stub
		return reviewrepo.findAll();
	}

	@Override
	public List<Review> getreviewsByProductId(Long productId) {
		// TODO Auto-generated method stub
		return reviewrepo.findByProduct_Id(productId);
	}

	@Override
	public List<Review> getreviewByUserId(Long userId) {
		// TODO Auto-generated method stub
		return reviewrepo.findByUser_Id(userId);
	}

	@Override
	public void deleteReview(Long id) {
		// TODO Auto-generated method stub
		reviewrepo.deleteById(id);
		
	}
	

}
