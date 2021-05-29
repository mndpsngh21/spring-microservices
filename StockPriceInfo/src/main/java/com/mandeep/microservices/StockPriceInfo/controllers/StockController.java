package com.mandeep.microservices.StockPriceInfo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/stock")
public class StockController {
	
	

@GetMapping(path = "/")	
public StockListResponse getBrokerList()
{
	StockListResponse stockListResponse = new StockListResponse();
    
	ArrayList<Stock>stocks= new ArrayList<Stock>();
	
  	Stock stock= new Stock();
  	stock.setName("Stock1");
  	stock.setCode("STK1");
  	stock.setClosePrice(1450);
  	stock.setOpenPrice(14545);
  	stock.setPrice(5000);
  	stocks.add(stock);

  	Stock stock1= new Stock();
  	stock1.setName("Stock2");
  	stock1.setCode("STK2");
  	stock1.setClosePrice(1450);
  	stock1.setOpenPrice(14545);
  	stock1.setPrice(5000);
  	stocks.add(stock1);

  	Stock stock3= new Stock();
  	stock3.setName("Stock3");
  	stock3.setCode("STK3");
  	stock3.setClosePrice(1450);
  	stock3.setOpenPrice(14545);
  	stock3.setPrice(5000);
  	stocks.add(stock3);

  	stockListResponse.createSuccessObject("Success");
  	stockListResponse.setStocks(stocks);
  	
	return stockListResponse;
}
	

}
