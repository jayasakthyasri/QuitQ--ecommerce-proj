package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import com.springboot.Quitq_ecommerce_proj.Entities.TrackingDetails;

public interface TrackingDetailsService {
	
	TrackingDetails createtracking(TrackingDetails trackingdetails);
	
	TrackingDetails gettrackingdetailsById(Long id);
	
	List<TrackingDetails> getalltracks();
	
	void deleteAlltracksbyid(Long id);
	
	
	
	

}
