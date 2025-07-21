package com.springboot.Quitq_ecommerce_proj.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Quitq_ecommerce_proj.Entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}
