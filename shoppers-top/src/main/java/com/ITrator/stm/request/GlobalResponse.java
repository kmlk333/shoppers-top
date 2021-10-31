package com.ITrator.stm.request;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class GlobalResponse
{
	Map<String, Object> globalResponse = new HashMap<>();

	private Map<String, Object> errors = new LinkedHashMap<>();

	private HttpStatus statusCode;

	public Map<String, Object> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, Object> errors) {
		this.errors = errors;
	}

	private String message;

	public Map<String, Object> getGlobalResponse() {
		return globalResponse;
	}

	public void setGlobalResponse(Map<String, Object> globalResponse) {
		this.globalResponse = globalResponse;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
