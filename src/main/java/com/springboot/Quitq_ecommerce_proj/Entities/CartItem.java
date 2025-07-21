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
@Table(name="cartItem")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart_id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product_id;


	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(Long id, Cart cart_id, Product product_id, Long quantity) {
		super();
		this.id = id;
		this.cart_id = cart_id;
		this.product_id = product_id;
		this.quantity = quantity;
	}
	public Long getid() {
		return id;
	}
	public void setid(Long cart) {
		this.id = cart;
	}
	public Cart getCart_id() {
		return cart_id;
	}
	public void setCart_id(Cart cart_id) {
		this.cart_id = cart_id;
	}
	public Product getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Product product_id) {
		this.product_id = product_id;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
}
