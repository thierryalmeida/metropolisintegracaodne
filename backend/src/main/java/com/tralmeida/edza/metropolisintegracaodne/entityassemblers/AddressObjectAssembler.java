package com.tralmeida.edza.metropolisintegracaodne.entityassemblers;

import java.util.List;
import java.util.Optional;

public interface AddressObjectAssembler<T> {
	
	public Optional<T> toAssemble(List<String> fields);
	public boolean saveAndMerge(T entity);
}
