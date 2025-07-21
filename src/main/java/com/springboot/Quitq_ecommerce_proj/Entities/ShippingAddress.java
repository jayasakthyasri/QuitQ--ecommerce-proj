package com.springboot.Quitq_ecommerce_proj.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="shippingAddress")
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String address;

    @Column(nullable=false)
    private String city;

    @Column(nullable=false)
    private String pincode;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
	
	public ShippingAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ShippingAddress(Long id, User user_id, String address, String city, String pincode) {
		super();
		this.id = id;
		this.user= user_id;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
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
		this.user = user_id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	
	
	

}
