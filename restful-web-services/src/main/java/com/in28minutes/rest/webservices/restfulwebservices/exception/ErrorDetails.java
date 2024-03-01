package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	//timestamp
	//message
	//details
	private LocalDateTime dateTimeStamp;
	private String message;
	private String details;
	
	public ErrorDetails(LocalDateTime dateTimeStamp, String message, String details) {
		super();
		this.dateTimeStamp = dateTimeStamp;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getDateTimeStamp() {
		return dateTimeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
	
	
}
