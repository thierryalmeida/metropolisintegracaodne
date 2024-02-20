package com.tralmeida.edza.metropolisintegracaodne.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tralmeida.edza.metropolisintegracaodne.dto.BairroLogradouroDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.Bairro;
import com.tralmeida.edza.metropolisintegracaodne.entities.BairroLogradouro;
import com.tralmeida.edza.metropolisintegracaodne.entities.Logradouro;
import com.tralmeida.edza.metropolisintegracaodne.repositories.BairroLogradouroRepository;

@Service
public class BairroLogradouroService {
	
	@Autowired
	BairroLogradouroRepository repository;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public BairroLogradouro saveAndFlush(BairroLogradouroDTO bairroLogradouroDTO) {
		BairroLogradouro entity = getEntityByDTO(bairroLogradouroDTO);
		return repository.saveAndFlush(entity);
	}
	
	public boolean exists(BairroLogradouroDTO bairroLogradouroDTO) {
		BairroLogradouro bairroLogradouro = repository.findByBairroAndLogradouro(bairroLogradouroDTO.getBairro().getBairroId(), 
				bairroLogradouroDTO.getLogradouro().getLogradouroId());
		return bairroLogradouro != null;
	}
	
	private BairroLogradouro getEntityByDTO(BairroLogradouroDTO dto) {
		BairroLogradouro entity = new BairroLogradouro();
		entity.setBairro(new Bairro());
		entity.getBairro().setBairroId(dto.getBairro().getBairroId());
		entity.setLogradouro(new Logradouro());
		entity.getLogradouro().setLogradouroId(dto.getLogradouro().getLogradouroId());
		
		return entity;
	}
}
