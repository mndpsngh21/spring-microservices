package com.mandeep.microservices.StockPriceInfo;

import java.util.ArrayList;
import java.util.List;



public class StockListResponse extends GenericReponse{
	
	public List<Stock> stocks= new ArrayList<Stock>();

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	
}
