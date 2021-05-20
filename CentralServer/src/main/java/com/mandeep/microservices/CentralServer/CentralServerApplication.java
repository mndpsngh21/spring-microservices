package com.mandeep.microservices.CentralServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CentralServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralServerApplication.class, args);
	}
	
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		RestTemplate restTemplate= new RestTemplate();
		return restTemplate;
	}

}
