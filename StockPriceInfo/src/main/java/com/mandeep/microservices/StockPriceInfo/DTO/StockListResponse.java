package com.mandeep.microservices.StockPriceInfo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.mandeep.microservices.StockPriceInfo.models.Stock;



public class StockListResponse extends GenericReponse{
	
	public List<Stock> stocks= new ArrayList<Stock>();

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	
}
