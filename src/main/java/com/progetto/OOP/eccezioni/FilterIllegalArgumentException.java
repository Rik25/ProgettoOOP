package com.progetto.OOP.eccezioni;

public class FilterIllegalArgumentException extends IllegalArgumentException{


	private static final long serialVersionUID = 4L;

	public FilterIllegalArgumentException() {
		super();
	}

	public FilterIllegalArgumentException(String message) {
		super(message);
	}
}
