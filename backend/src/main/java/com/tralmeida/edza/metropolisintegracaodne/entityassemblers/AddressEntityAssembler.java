package com.tralmeida.edza.metropolisintegracaodne.entityassemblers;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressEntityAssembler<T> {
	
	public T get();
	
	public Optional<T> toAssemble(List<String> fields);
	public JpaRepository<T, Long> getEntityRepository();
}
