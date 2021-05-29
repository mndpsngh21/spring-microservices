package com.mandeep.microservices.StockPriceInfo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandeep.microservices.StockPriceInfo.entities.StockInfo;
import com.mandeep.microservices.StockPriceInfo.exceptions.StockNotFoundException;
import com.mandeep.microservices.StockPriceInfo.models.Stock;
import com.mandeep.microservices.StockPriceInfo.repositiories.StockInfoRepository;

/**
 * 
 * @author Mandeep
 *
 * This service is to presist information in DB
 * 
 */
@Service
public class StockDataService {
	
	@Autowired
	StockInfoRepository stockInfoRepo;
	
	
	/*
	 * Save new stock information
	 */
	public Stock saveStock(Stock stock)
	{
		StockInfo stockInfo=from(stock);
		StockInfo info= stockInfoRepo.save(stockInfo);
		return from(info);
	}

	
	/**
	 * Get Stock information based on stock id
	 * @param id
	 * @return
	 * @throws StockNotFoundException
	 */
	public StockInfo getStockInfoById(int id) throws StockNotFoundException
	{
		StockInfo stock = stockInfoRepo.findById(id).get();
		if(stock==null)
		{
			throw new StockNotFoundException("Stock is not found");
		}
		return stock;
	}
	
	/** Get Stock DTO from id
	 * 
	 * @param id
	 * @return
	 * @throws StockNotFoundException
	 */
	public Stock getStockById(int id) throws StockNotFoundException
	{
		StockInfo stock =getStockInfoById(id);
		return from(stock);
	}
	
	/**
	 * Update existing Stock information
	 * @param stock
	 * @return
	 * @throws StockNotFoundException
	 */
	public Stock updateStock(Stock stock) throws StockNotFoundException
	{
		StockInfo existingStock= getStockInfoById(stock.getId());
		if(existingStock!=null)
		{
			StockInfo stockInfo=from(stock);
			StockInfo info= stockInfoRepo.save(stockInfo);
			return from(info);			
		}
		return stock;
	}
	
	/**
	 * Delete any existing stock from DB
	 * @param stock
	 * @return
	 * @throws StockNotFoundException
	 */
	public boolean deleteStock(Stock stock) throws StockNotFoundException
	{
		StockInfo existingStock= getStockInfoById(stock.getId());
		if(existingStock!=null)
		{
			stockInfoRepo.delete(existingStock);
		}
		return false;
	}
	
	
	public List<Stock> getAllStocks()
	{
	  List<StockInfo> stockInfos=stockInfoRepo.findAll();
	  List<Stock> stocks= stockInfos.stream()
			                        .map(ob -> from(ob))
			                        .collect(Collectors.toList());
	  return stocks;
	}
	
	
	
	/**
	 * Convert Entity Class to DTO Class
	 * @param stockInfo
	 * @return
	 */
	public Stock from(StockInfo stockInfo)
	{
		Stock stock= new Stock();
		stock.setName(stockInfo.getStockName());
		stock.setCode(stockInfo.getStockCode());
		stock.setId(stockInfo.getId());
		stock.setOpenPrice(stockInfo.getPrice());
		return stock;
	}
	
	/**
	 * Convert DTO Class to Entity Class
	 * @param stock
	 * @return
	 */
	public StockInfo from(Stock stock)
	{
		StockInfo stockInfo= new StockInfo();
		stockInfo.setId(stock.getId());
		stockInfo.setPrice(stock.getClosePrice());
		stockInfo.setStockName(stock.getName());
		stockInfo.setStockCode(stock.getCode());
		return stockInfo;
	}
	

}
