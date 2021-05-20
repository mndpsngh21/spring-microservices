package com.mandeep.microservices.CentralServer.Models.stocks;

import java.util.ArrayList;
import java.util.List;

import com.mandeep.microservices.CentralServer.Models.GenericReponse;

public class StockListResponse extends GenericReponse{
	
	public List<Stock> stocks= new ArrayList<Stock>();

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	
}
