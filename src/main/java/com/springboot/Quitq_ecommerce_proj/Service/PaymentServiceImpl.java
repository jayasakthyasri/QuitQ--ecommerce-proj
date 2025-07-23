package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.Payment;
import com.springboot.Quitq_ecommerce_proj.Entities.User;
import com.springboot.Quitq_ecommerce_proj.Repositories.PaymentRepository;
import com.springboot.Quitq_ecommerce_proj.Repositories.UserRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	private PaymentRepository paymentrepo;
	private UserRepository userrepo;
	public PaymentServiceImpl(PaymentRepository paymentrepo, UserRepository userrepo) {
		super();
		this.paymentrepo = paymentrepo;
		this.userrepo=userrepo;
	}

	@Override
	public Payment createPayment(Payment payment) {
		// TODO Auto-generated method stub
		Long userid = payment.getUser_id().getId();
		
		User user = userrepo.findById(userid).orElseThrow(()->new RuntimeException("user not found"));
		
		payment.setUser_id(user);
		
		return paymentrepo.save(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {
		// TODO Auto-generated method stub
		return paymentrepo.findById(id).orElse(null);
	}

	@Override
	public List<Payment> getallpayments() {
		// TODO Auto-generated method stub
		return paymentrepo.findAll();
	}

	@Override
	public void deletePaymentbyid(Long id) {
		// TODO Auto-generated method stub
		paymentrepo.deleteById(id);
	}

	
	

}
