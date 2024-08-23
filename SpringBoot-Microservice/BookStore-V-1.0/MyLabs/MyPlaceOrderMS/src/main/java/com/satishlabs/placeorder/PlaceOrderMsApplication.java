package com.satishlabs.placeorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PlaceOrderMsApplication implements CommandLineRunner {
	static Logger logger = LoggerFactory.getLogger(PlaceOrderMsApplication.class);

	public static void main(String[] args) {
		logger.info("PlaceOrderMS - Begin");
		SpringApplication.run(PlaceOrderMsApplication.class, args);
		logger.info("PlaceOrderMS - End");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("PlaceOrderMS - Launched...");

	}

}
