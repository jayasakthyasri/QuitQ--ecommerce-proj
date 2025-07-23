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

import com.springboot.Quitq_ecommerce_proj.Entities.Payment;
import com.springboot.Quitq_ecommerce_proj.Service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	public PaymentController(PaymentService paymentservice) {
		super();
		this.paymentservice = paymentservice;
	}

	private PaymentService paymentservice;
	
	@PostMapping
	public ResponseEntity<Payment> createpayment(@RequestBody Payment payment)
	{
		Payment savedpay = paymentservice.createPayment(payment);
		return new ResponseEntity<>(savedpay,HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Payment>> getallpayments()
	{
		List<Payment> savedpay = paymentservice.getallpayments();
		return new ResponseEntity<>(savedpay,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Payment> getpaymentid(@PathVariable("id") Long id)
	{
		Payment savedpay = paymentservice.getPaymentById(id);
		return new ResponseEntity<>(savedpay,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Payment> deletepayment(@PathVariable("id") Long id)
	{
		paymentservice.deletePaymentbyid(id);
		return new ResponseEntity("deleted the payment successfully",HttpStatus.OK);
	}
}
