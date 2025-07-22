package com.springboot.Quitq_ecommerce_proj.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // This is your actual order_id

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Column(nullable=false)
    private String status;

    @Column(name = "total_price")
    private Double total_price;

    @Column(name = "created_at")
    private LocalDateTime created_at;
    
    public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Order(Long id, User user_id, Payment payment_id, String status, Double total_price, LocalDateTime created_at) {
		super();
		this.id = id;
		this.user = user_id;
		this.payment = payment_id;
		this.status = status;
		this.total_price = total_price;
		this.created_at = created_at;
	}

	public Payment getPayment_id() {
		return payment;
	}

	public void setPayment_id(Payment payment_id) {
		this.payment = payment_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser_id() {
		return user;
	}

	public void setUser_id(User user_id) {
		this.user= user_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	
}

