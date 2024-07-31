package com.satishlabs.cabservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.cabservice.model.Cab;
import com.satishlabs.cabservice.service.CabService;

@RestController
@RequestMapping("/api/cabs")
public class CabController {
	
	@Autowired
	private CabService cabService;
	
	@GetMapping("/available")
	public ResponseEntity<List<String>> getAvailableCabs(@RequestParam String location){
		List<String> availableCabs = cabService.getAvailableCabsByLocation(location);
		return ResponseEntity.ok(availableCabs);
	}
	
	@PostMapping("/book")
	public ResponseEntity<String> bookCab(@RequestParam String cabId,@RequestParam String newLocation){
		cabService.bookCab(cabId, newLocation);
		return ResponseEntity.ok("Cab booked successfully");
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Cab>> getAllCabs(){
		List<Cab> cabs = cabService.getAllCabs();
		return ResponseEntity.ok(cabs);
	}
}
