package com.springboot.Quitq_ecommerce_proj.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.Quitq_ecommerce_proj.Entities.TrackingDetails;
import com.springboot.Quitq_ecommerce_proj.Repositories.TrackingDetailsRepository;


@Service
public class TrackingDetailsServiceImpl implements TrackingDetailsService {
	
	private TrackingDetailsRepository trackdetrepo;

	public TrackingDetailsServiceImpl(TrackingDetailsRepository trackdetrepo) {
		super();
		this.trackdetrepo = trackdetrepo;
	}

	@Override
	public TrackingDetails createtracking(TrackingDetails trackingdetails) {
		// TODO Auto-generated method stub
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
