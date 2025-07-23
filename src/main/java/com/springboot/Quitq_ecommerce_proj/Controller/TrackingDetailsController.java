package com.springboot.Quitq_ecommerce_proj.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Quitq_ecommerce_proj.Entities.TrackingDetails;
import com.springboot.Quitq_ecommerce_proj.Service.TrackingDetailsService;


@RestController
@RequestMapping("/api/trackingdetails")
public class TrackingDetailsController {
	
	private TrackingDetailsService trackdetservice;

	public TrackingDetailsController(TrackingDetailsService trackdetservice) {
		super();
		this.trackdetservice = trackdetservice;
	}
	
	@PostMapping 
	public ResponseEntity<TrackingDetails> createTrackingdet(@RequestBody TrackingDetails trackdet)
	{
		TrackingDetails savedtrack = trackdetservice.createtracking(trackdet);
		return new ResponseEntity<>(savedtrack,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TrackingDetails> gettrackdetbyid(@PathVariable("id") Long id)
	{
		TrackingDetails savedtrack = trackdetservice.gettrackingdetailsById(id);
		return new ResponseEntity<>(savedtrack,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<TrackingDetails>> getalltrackdetails()
	{
		List<TrackingDetails> savedtracks = trackdetservice.getalltracks();
		return new ResponseEntity<>(savedtracks,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<TrackingDetails> deletetrackbyid(@PathVariable("id") Long id)
	{
		trackdetservice.deleteAlltracksbyid(id);
		return new ResponseEntity("deleted the trackingdetails successfully",HttpStatus.OK);
	}
}
