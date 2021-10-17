package com.ITrator.stm.exception;

import javax.security.auth.message.AuthException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExcpetionHandler extends ResponseEntityExceptionHandler 
{
	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(
      RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
	
	@ExceptionHandler(value = { Exception.class})
    protected ResponseEntity<Object> defaultException (Exception ex, WebRequest request) {
		ExceptionMessage resMessage = new ExceptionMessage();
		resMessage.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		resMessage.setErrorMessage(ex.getMessage());
        return handleExceptionInternal(ex, resMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
	
	@ExceptionHandler(value = { CustomException.class})
    protected ResponseEntity<Object> customException (CustomException ex, WebRequest request) {
		ExceptionMessage resMessage = new ExceptionMessage();
		resMessage.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		resMessage.setErrorMessage(ex.getMessage());
        return handleExceptionInternal(ex, resMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
	
	@ExceptionHandler(value = { AuthException.class})
    protected ResponseEntity<Object> unauthorizedException (AuthException ex, WebRequest request) {
		ExceptionMessage resMessage = new ExceptionMessage();
		resMessage.setErrorCode(HttpStatus.UNAUTHORIZED.toString());
		resMessage.setErrorMessage(ex.getMessage());
        return handleExceptionInternal(ex, resMessage, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }
}

