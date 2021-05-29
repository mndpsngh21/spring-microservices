package com.mandeep.microservices.StockPriceInfo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mandeep.microservices.StockPriceInfo.DTO.GenericReponse;
import com.mandeep.microservices.StockPriceInfo.DTO.StockListResponse;
import com.mandeep.microservices.StockPriceInfo.models.Stock;
import com.mandeep.microservices.StockPriceInfo.services.StockDataService;

@RestController
@RequestMapping(path = "/stock")
public class StockController {
	

@Autowired	
StockDataService stockDataService;
	
	
@GetMapping(path = "/")	
public StockListResponse getBrokerList()
{
	StockListResponse stockListResponse = new StockListResponse();
    List<Stock> stocks= stockDataService.getAllStocks();
	stockListResponse.createSuccessObject("Success");
	stockListResponse.setStocks(stocks);
	return stockListResponse;
}


@GetMapping(path = "/SampleStockObject")	
public Stock getSampleData()
{
	Stock stock = new Stock();
    return stock;
}


@PostMapping(path="/")
public GenericReponse saveNewStock(Stock stock)
{
	GenericReponse response= new GenericReponse();
	Stock insetedStock= stockDataService.saveStock(stock);
	if(insetedStock.getId()>0)
	{
		response.createSuccessObject(String .valueOf(insetedStock.getId()));
	}	
	return response;
}
	

}
