package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Configuration
	public class WebConfig implements WebMvcConfigurer {

	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")  // Apply to all endpoints
	                .allowedOrigins("http://localhost:5000")  // Allow the specific origin
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow specific methods
	                .allowedHeaders("Authorization", "Content-Type")  // Allow all headers
	                .allowCredentials(true);  // Allow credentials (e.g., cookies, authorization headers)
	    }
	}

}
