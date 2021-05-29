package com.mandeep.microservices.StockPriceInfo;

public class GenericReponse {
	
	
	public String message;
	public int responseCode;
	public boolean isSuccess;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	
	public void createSuccessObject(String message)
	{
		this.isSuccess=true;
		this.responseCode=200;
		this.message=message;
	}
	

}
