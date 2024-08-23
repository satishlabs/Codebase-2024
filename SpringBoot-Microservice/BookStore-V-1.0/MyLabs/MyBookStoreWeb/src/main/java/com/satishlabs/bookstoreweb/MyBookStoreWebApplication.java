package com.satishlabs.bookstoreweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBookStoreWebApplication implements CommandLineRunner {
	static Logger logger = LoggerFactory.getLogger(MyBookStoreWebApplication.class);
	public static void main(String[] args) {
		logger.info("BookStoreWeb - Begin");
		SpringApplication.run(MyBookStoreWebApplication.class, args);
		logger.info("BookStoreWeb - End");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("BookStoreWeb - Launched...");
		
	}

}
