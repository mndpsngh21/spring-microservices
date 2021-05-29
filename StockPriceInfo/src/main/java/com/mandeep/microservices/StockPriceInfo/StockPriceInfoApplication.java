package com.mandeep.microservices.StockPriceInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mandeep.microservices.StockPriceInfo.models.Stock;
import com.mandeep.microservices.StockPriceInfo.services.StockDataService;

@SpringBootApplication
public class StockPriceInfoApplication implements CommandLineRunner{

	@Autowired
	StockDataService stockDataService;
	
	public static void main(String[] args) {
		SpringApplication.run(StockPriceInfoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//	stockDataService.saveStock(new Stock(1,"JK Industries","CMC",140d,150d));
	//	stockDataService.saveStock(new Stock(2,"Dashmesh Constructs","DCS",140d,170d));
	//	stockDataService.saveStock(new Stock(3,"Prince Traders","PRTD",130d,118d));
	}

}
