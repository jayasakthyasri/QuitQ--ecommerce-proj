package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.Order;
import com.springboot.Quitq_ecommerce_proj.Entities.TrackingDetails;
import com.springboot.Quitq_ecommerce_proj.Repositories.OrderRepository;
import com.springboot.Quitq_ecommerce_proj.Repositories.TrackingDetailsRepository;


@Service
public class TrackingDetailsServiceImpl implements TrackingDetailsService {
	
	private TrackingDetailsRepository trackdetrepo;
	private OrderRepository orderrepo;

	public TrackingDetailsServiceImpl(TrackingDetailsRepository trackdetrepo, OrderRepository orderrepo) {
		super();
		this.trackdetrepo = trackdetrepo;
		this.orderrepo = orderrepo;
	}

	@Override
	public TrackingDetails createtracking(TrackingDetails trackingdetails) {
		// TODO Auto-generated method stub
		Long order_id = trackingdetails.getOrder().getId();
		
		Order order= orderrepo.findById(order_id).orElse(null);
		
		trackingdetails.setOrder(order);
		
		return trackdetrepo.save(trackingdetails);
	}

	@Override
	public TrackingDetails gettrackingdetailsById(Long id) {
		// TODO Auto-generated method stub
		return trackdetrepo.findById(id).orElse(null);
	}

	@Override
	public List<TrackingDetails> getalltracks() {
		// TODO Auto-generated method stub
		return trackdetrepo.findAll();
	}

	@Override
	public void deleteAlltracksbyid(Long id) {
		// TODO Auto-generated method stub
		trackdetrepo.deleteById(id);
	}
	
	
	

}
