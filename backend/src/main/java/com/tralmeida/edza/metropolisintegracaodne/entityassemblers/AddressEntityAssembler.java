package com.tralmeida.edza.metropolisintegracaodne.entityassemblers;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface AddressEntityAssembler {
	
	public Optional<?> toAssemble(List<String> fields);
	public Service getEntityService();
}
