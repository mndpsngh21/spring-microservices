package com.mandeep.microservices.StockPriceInfo.models;

/**
 * DTO Object
 * @author Mandeep
 *
 */
public class Stock {

	String name;
	String code;
	double price;
	double closePrice;
	double openPrice;
	int id;
	
	public Stock()
	{
		
	}
	
	
	public Stock(int _id, String _name, String _code, double _openPrice, double _closePrice) {
		this.id=_id;
		this.name=_name;
		this.code=_code;
		this.openPrice=_openPrice;
		this.closePrice=_closePrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}
	public double getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
}
