package com.tralmeida.edza.metropolisintegracaodne.entityassemblers;

import java.util.List;
import java.util.Optional;

public interface AddressObjectAssembler<T> {
	
	Optional<T> toAssemble(List<String> fields);
	boolean saveAndMerge(T entity);
}
