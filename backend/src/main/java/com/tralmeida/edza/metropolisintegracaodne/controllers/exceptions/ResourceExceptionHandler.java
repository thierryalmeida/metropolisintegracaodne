package com.tralmeida.edza.metropolisintegracaodne.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tralmeida.edza.metropolisintegracaodne.services.exceptions.AddressEntityNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(value = AddressEntityNotFoundException.class)
	public StandardError addressEntityNotFound(AddressEntityNotFoundException ex, HttpServletRequest request) {
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setError("Address Entity not found");
		error.setMessage(ex.getMessage());
		error.setPath(request.getRequestURI());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		return error;
	}

}
