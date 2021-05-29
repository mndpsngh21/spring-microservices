package com.mandeep.microservices.CentralServer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mandeep.microservices.CentralServer.Models.GenericReponse;
import com.mandeep.microservices.CentralServer.Models.stocks.Stock;
import com.mandeep.microservices.CentralServer.Models.stocks.StockListResponse;



@RestController
public class StockController {

@Autowired
RestTemplate restTemplate;
	
@Value("${service.stockservice}")
String STOCK_SERVICE;

@Autowired
private DiscoveryClient discoveryClient;

@RequestMapping("/service-instances/{applicationName}")
public List<ServiceInstance> serviceInstancesByApplicationName(
		@PathVariable String applicationName) {
	return this.discoveryClient.getInstances(applicationName);
}

@RequestMapping("/service-instances")
public List<String> serviceInstances() {
	return this.discoveryClient.getServices();
}


@GetMapping(path = "/stock")	
public StockListResponse getBrokerList()
{
	System.out.println("Service URL :: "+STOCK_SERVICE);
	ResponseEntity<StockListResponse> stockListResponse= restTemplate.getForEntity(STOCK_SERVICE+"/stock/", StockListResponse.class);  	
	return stockListResponse.getBody();
}



@GetMapping(path = "/SampleStockObject")	
public Stock getSampleData()
{
	ResponseEntity<Stock> stockListResponse= restTemplate.getForEntity(STOCK_SERVICE+"/stock/SampleStockObject/", Stock.class);  	
	return stockListResponse.getBody();
}


@PostMapping(path="/")
public GenericReponse saveNewStock(Stock stock)
{
	ResponseEntity<GenericReponse> stockListResponse= restTemplate.postForEntity(STOCK_SERVICE+"/SampleStockObject/",stock, GenericReponse.class);  	
	return stockListResponse.getBody();
}
	
	
}
