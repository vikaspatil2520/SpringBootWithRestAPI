package com.practice.springbootbasics.exception;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ExceptionResponse {

	private Date timestamp;
	private String message;
	private String details;

	public ExceptionResponse()
	{
		
	}
	public ExceptionResponse(Date timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails()
	{
	return details;
    }
}