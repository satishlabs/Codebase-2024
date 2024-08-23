package com.satishlabs.booksearch.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
@Configuration
public class BookSearchConfig implements WebMvcConfigurer {

	 @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	                .info(new Info()
	                        .title("My BookSearchMS Applications")
	                        .version("1.0")
	                        .description("This is a BookSearchMS Spring Boot RESTful service using springdoc-openapi and OpenAPI 3.")
	                        .contact(new Contact()
	                                .name("Satish Prasad")
	                                .url("https://satishlabs.com")
	                                .email("satishlabs@domain.com")));
	    }
}