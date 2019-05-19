package com.remon.store.data.exceptions;

import com.remon.store.common.exception.BaseException;

public class StoreHibernateException extends BaseException{

	private static final long serialVersionUID = 1L;
	
	private final static String DEFAULT_ERROR_MESSAGE = "Exception occured.";
	
	public StoreHibernateException() {
		super(DEFAULT_ERROR_MESSAGE);
	}
	
	public StoreHibernateException(String errorMessage) {
		super(errorMessage);
	}
	
	public StoreHibernateException(Throwable e) {
		super(e);
	}

	@Override
	public int getErrorCode() {
		return 0;
	}
}
