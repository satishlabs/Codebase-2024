package com.satishlabs.userrating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyUserRatingMsApplication implements CommandLineRunner{
	static Logger logger = LoggerFactory.getLogger(MyUserRatingMsApplication.class);
	
	public static void main(String[] args) {
		logger.info("UserRatingMS --- Begin...");
		SpringApplication.run(MyUserRatingMsApplication.class, args);
		logger.info("UserRatingMS --- End...");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("UserRatingMS --- Launched...");
		
	}

}
