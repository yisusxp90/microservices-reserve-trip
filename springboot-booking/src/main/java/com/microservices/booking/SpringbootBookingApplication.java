package com.microservices.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBookingApplication.class, args);
	}

	@LoadBalanced
	@Bean
	public RestTemplate crearTemplate() {
		return new RestTemplate();
	}
}
