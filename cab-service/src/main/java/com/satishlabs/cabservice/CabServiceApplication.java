package com.satishlabs.cabservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.satishlabs.cabservice.model.Cab;
import com.satishlabs.cabservice.repository.CabRepository;

@SpringBootApplication
public class CabServiceApplication implements CommandLineRunner{
	
	@Autowired
	private CabRepository cabRepository;

	public static void main(String[] args) {
		SpringApplication.run(CabServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Initialize some cabs
		cabRepository.save(new Cab("CAB001", "LocationA", false));
		cabRepository.save(new Cab("CAB002", "LocationB", false));
		cabRepository.save(new Cab("CAB003", "LocationC", false));
		cabRepository.save(new Cab("CAB004", "LocationD", false));
		
	}

}
