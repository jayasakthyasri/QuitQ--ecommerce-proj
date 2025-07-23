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
@Table(name="cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cartid;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productid;


	
	public CartItem() {
		super();
		
	}
	public CartItem(Long id, Cart cart_id, Product product_id, Long quantity) {
		super();
		this.id = id;
		this.cartid = cart_id;
		this.productid = product_id;
		this.quantity = quantity;
	}
	public Long getid() {
		return id;
	}
	public void setid(Long cart) {
		this.id = cart;
	}
	public Cart getCartid() {
		return cartid;
	}
	public void setCartid(Cart cart_id) {
		this.cartid = cart_id;
	}
	public Product getProductid() {
		return productid;
	}
	public void setProductid(Product product_id) {
		this.productid = product_id;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
}
