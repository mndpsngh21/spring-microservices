package com.mandeep.microservices.CentralServer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mandeep.microservices.CentralServer.Models.stocks.StockListResponse;



@RestController
public class StockController {

@Autowired
RestTemplate restTemplate;
	
@GetMapping(path = "/stock")	
public StockListResponse getBrokerList()
{
	ResponseEntity<StockListResponse> stockListResponse= restTemplate.getForEntity("http://localhost:8100/stock/", StockListResponse.class);  	
	return stockListResponse.getBody();
}
	
	
}
