package com.springboot.Quitq_ecommerce_proj.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="trackingdetails")
public class TrackingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "courier_name")
    private String courier_name;

    @Column(name = "tracking_number")
    private String tracking_number;

    @Column(nullable=false)
    private String status;

    @Column(name = "estimated_delivery")
    private LocalDateTime estimated_delivery;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
	
	public TrackingDetails(Long id, Order order_id, String courier_name, String tracking_number, String status,
			LocalDateTime estimated_delivery) {
		super();
		this.id = id;
		this.order = order_id;
		this.courier_name = courier_name;
		this.tracking_number = tracking_number;
		this.status = status;
		this.estimated_delivery = estimated_delivery;
	}
	public TrackingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Order getOrder_id() {
		return order;
	}
	public void setOrder_id(Order order_id) {
		this.order = order_id;
	}
	public String getCourier_name() {
		return courier_name;
	}
	public void setCourier_name(String courier_name) {
		this.courier_name = courier_name;
	}
	public String getTracking_number() {
		return tracking_number;
	}
	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getEstimated_delivery() {
		return estimated_delivery;
	}
	public void setEstimated_delivery(LocalDateTime estimated_delivery) {
		this.estimated_delivery = estimated_delivery;
	}
	
	
	

}
