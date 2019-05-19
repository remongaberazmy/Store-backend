package com.remon.store.common.base;

import java.io.Serializable;

public abstract class AbstractDTO<T extends Serializable> implements Serializable{

	private static final long serialVersionUID = 1L;

	public abstract T PK();
}