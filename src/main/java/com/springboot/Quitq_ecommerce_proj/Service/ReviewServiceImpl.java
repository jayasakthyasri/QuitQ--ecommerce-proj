package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.Product;
import com.springboot.Quitq_ecommerce_proj.Entities.Review;
import com.springboot.Quitq_ecommerce_proj.Entities.User;
import com.springboot.Quitq_ecommerce_proj.Repositories.ProductRepository;
import com.springboot.Quitq_ecommerce_proj.Repositories.ReviewRepository;
import com.springboot.Quitq_ecommerce_proj.Repositories.UserRepository;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	public ReviewServiceImpl(ReviewRepository reviewrepo, ProductRepository productrepo, UserRepository userrepo) {
		super();
		this.reviewrepo = reviewrepo;
		this.productrepo=productrepo;
		this.userrepo = userrepo;
	}

	private ReviewRepository reviewrepo;
	private ProductRepository productrepo;
	private UserRepository userrepo;

	@Override
	public Review createreview(Review review) {
		// TODO Auto-generated method stub
		
		Long product_id = review.getProduct().getId();
		Product product = productrepo.findById(product_id).orElse(null);
		review.setProduct(product);
		
		Long user_id = review.getUser().getId();
		User user = userrepo.findById(user_id).orElse(null);
		review.setUser(user);
		
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
