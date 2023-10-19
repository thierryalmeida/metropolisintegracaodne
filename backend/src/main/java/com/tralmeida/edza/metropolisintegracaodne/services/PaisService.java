package com.tralmeida.edza.metropolisintegracaodne.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tralmeida.edza.metropolisintegracaodne.entities.Pais;
import com.tralmeida.edza.metropolisintegracaodne.repositories.PaisRepository;

@Service
public class PaisService{
	
	@Autowired
	private PaisRepository repository;
	
	@Transactional
	public Pais saveEntity(Pais entity) {
		return repository.saveAndFlush(entity);
	}

}
