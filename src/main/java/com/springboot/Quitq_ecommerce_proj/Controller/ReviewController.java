package com.springboot.Quitq_ecommerce_proj.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Quitq_ecommerce_proj.Entities.Review;
import com.springboot.Quitq_ecommerce_proj.Service.ReviewService;


@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
	
	public ReviewController(ReviewService reviewservice) {
		super();
		this.reviewservice = reviewservice;
	}

	private ReviewService reviewservice;
	
	@PostMapping
	public ResponseEntity<Review> createreview(@RequestBody Review review)
	{
		Review savedreview = reviewservice.createreview(review);
		return new ResponseEntity<>(savedreview,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Review> getreviewByid(@PathVariable("id") Long id)
	{
		Review savedreviews = reviewservice.getReviewByid(id);
		return new ResponseEntity<>(savedreviews,HttpStatus.OK);
		 
	}
	
	@GetMapping
	public ResponseEntity<List<Review>> getALLreview()
	{
	  List<Review> savedreviews = reviewservice.getAllreview();
	  return new ResponseEntity<>(savedreviews,HttpStatus.OK);
	}
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<List<Review>> getReviewByProduct(@PathVariable("productId") Long productId)
	{
		List<Review> savedprodreviews = reviewservice.getreviewsByProductId(productId);
		return new ResponseEntity<>(savedprodreviews,HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Review>> getReviewByUser(@PathVariable("userId") Long userId)
	{
		List<Review> saveduserreviews = reviewservice.getreviewByUserId(userId);
		return new ResponseEntity<>(saveduserreviews,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Review> deleteByid(@PathVariable("id") Long id)
	{
		reviewservice.deleteReview(id);
		return new ResponseEntity("deleted the review successfully",HttpStatus.OK);
	}
	
	
	

}
