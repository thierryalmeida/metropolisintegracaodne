package com.tralmeida.edza.metropolisintegracaodne.services.exceptions;

public class AddressEntityNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public AddressEntityNotFoundException(String msg) {
		super(msg);
	}

}
