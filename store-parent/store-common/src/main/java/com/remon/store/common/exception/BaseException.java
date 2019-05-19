package com.remon.store.common.exception;

public abstract class BaseException extends RuntimeException implements Exception{

	private static final long serialVersionUID = 1L;

	private String errorMessage;
	
	private Throwable causeException;
	
	public BaseException(String message) {
		this.errorMessage = message;
	}
	
	public BaseException(Throwable e) {
		this.causeException = e;
	}
	
	@Override
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Throwable getCauseException() {
		if(causeException == null) {
			causeException = new java.lang.Exception(getErrorMessage());
		}
		return causeException;
	}

	public void setCauseException(Throwable causeException) {
		this.causeException = causeException;
	}
	
}
