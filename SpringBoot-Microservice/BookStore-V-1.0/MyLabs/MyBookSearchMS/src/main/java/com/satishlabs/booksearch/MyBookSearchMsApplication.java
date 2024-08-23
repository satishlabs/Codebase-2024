package com.satishlabs.booksearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MyBookSearchMsApplication implements CommandLineRunner {
	static Logger logger = LoggerFactory.getLogger(MyBookSearchMsApplication.class);

	public static void main(String[] args) {
		logger.info("BookSearch - Begin");
		SpringApplication.run(MyBookSearchMsApplication.class, args);
		logger.info("BookSearch - End");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("BookSearch - Launched...");

	}

}
