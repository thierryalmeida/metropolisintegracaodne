package com.tralmeida.edza.metropolisintegracaodne.entityassemblers;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.Entity;

public interface AddressEntityAssembler<T> {
	
	public Optional<T> toAssemble(List<String> fields);
	public boolean save(T entity);
}
