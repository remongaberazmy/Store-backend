package com.remon.store.common.exception;

import java.io.Serializable;

public interface Exception extends Serializable{

	String getErrorMessage();
	
	int getErrorCode();
	
}