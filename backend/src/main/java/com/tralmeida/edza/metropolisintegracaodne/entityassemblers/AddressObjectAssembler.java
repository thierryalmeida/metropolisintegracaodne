package com.tralmeida.edza.metropolisintegracaodne.entityassemblers;

import java.util.List;
import java.util.Optional;

import com.tralmeida.edza.metropolisintegracaodne.enums.ImportFile;

public interface AddressObjectAssembler<T> {
	
	Optional<T> toAssemble(List<String> fields, ImportFile file, Long importacaoId);
	boolean saveAndMerge(T entity);
}
