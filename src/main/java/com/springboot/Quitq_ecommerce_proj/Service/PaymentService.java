package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import com.springboot.Quitq_ecommerce_proj.Entities.Payment;

public interface PaymentService {
	
	Payment createPayment(Payment payment);
	
	Payment getPaymentById(Long id);
	
	List<Payment> getallpayments();
	
	void deletePaymentbyid(Long id);

}
