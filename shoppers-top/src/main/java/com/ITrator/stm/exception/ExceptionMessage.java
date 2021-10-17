package com.ITrator.stm.exception;

import lombok.Data;
import lombok.Getter;


public @Data class ExceptionMessage {
	private @Getter String errorCode;
	private @Getter String errorMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}