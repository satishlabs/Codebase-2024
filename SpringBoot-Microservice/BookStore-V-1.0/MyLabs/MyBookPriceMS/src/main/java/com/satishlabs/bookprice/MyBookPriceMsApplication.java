package com.satishlabs.bookprice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBookPriceMsApplication implements CommandLineRunner {
	static Logger logger = LoggerFactory.getLogger(MyBookPriceMsApplication.class);
	public static void main(String[] args) {
		logger.info("BookPrice - Begin");
		SpringApplication.run(MyBookPriceMsApplication.class, args);
		logger.info("BookPrice - End");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("BookPrice - Launched...");
		
	}

}
