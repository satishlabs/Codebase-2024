package com.satishlabs.cabservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.cabservice.model.Cab;

public interface CabRepository extends JpaRepository<Cab, String>{
	List<Cab> findByLocationAndIsAvailableTrue(String location);
	
}
