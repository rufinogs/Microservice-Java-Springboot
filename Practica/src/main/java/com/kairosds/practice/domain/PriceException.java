package com.kairosds.practice.domain;

public class PriceException extends Exception {
	private String message;
	
	public PriceException(String message){
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
	      
