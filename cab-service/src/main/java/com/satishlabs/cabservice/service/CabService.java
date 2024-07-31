package com.satishlabs.cabservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satishlabs.cabservice.model.Cab;
import com.satishlabs.cabservice.repository.CabRepository;

@Service
public class CabService {
	@Autowired
	private CabRepository cabRepository;
	
	public List<String> getAvailableCabsByLocation(String location){
		List<Cab> availanleCabs = cabRepository.findByLocationAndIsAvailableTrue(location);
		return availanleCabs.stream().map(Cab::getId).toList();
	}
	
	public void bookCab(String cabId,String newLocation) {
		Cab cab = cabRepository.findById(cabId)
				.orElseThrow(() -> new RuntimeException("Cab not found!"));
		if(cab.isAvailable()) {
			cab.setAvailable(false);
			cab.setLocation(newLocation);
			cabRepository.save(cab);
		}else {
			throw new RuntimeException("Cab is not availabe for booking");
		}
	}
	
	public List<Cab> getAllCabs(){
		return cabRepository.findAll();
	}
}
