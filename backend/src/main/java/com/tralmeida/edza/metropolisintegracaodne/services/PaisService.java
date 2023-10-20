package com.tralmeida.edza.metropolisintegracaodne.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tralmeida.edza.metropolisintegracaodne.entities.Pais;
import com.tralmeida.edza.metropolisintegracaodne.repositories.PaisRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PaisService{
	
	@Autowired
	private PaisRepository repository;
	
	@Transactional(readOnly = true)
	public Pais getBySigla(String sigla){
		Pais entity = null;
		try{
			entity = repository.getReferenceById(sigla);
		} catch (EntityNotFoundException e) {
			System.out.println("País com o id "+sigla+" não encontrado.");
		}
		return entity;
	}
	
	@Transactional
	public Pais saveEntity(Pais entity) {
		return repository.saveAndFlush(entity);
	}

}
