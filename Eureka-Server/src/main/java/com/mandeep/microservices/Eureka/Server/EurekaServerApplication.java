package com.mandeep.microservices.Eureka.Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author Mandeep
 * @EnableEurekaServer annotation marks this application as eureka server
 *   We need to add below dependency:
 *    <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency> 
		
		By default, the registry also tries to register itself, so you need to disable that behavior as well.
		We need to add below properties for same.
		 - eureka.client.register-with-eureka=false
         - eureka.client.fetch-registry=false
 
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
