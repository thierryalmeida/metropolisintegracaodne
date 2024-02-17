package com.tralmeida.edza.metropolisintegracaodne.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tralmeida.edza.metropolisintegracaodne.entities.TipoLogradouro;
import com.tralmeida.edza.metropolisintegracaodne.repositories.TipoLogradouroRepository;

@Service
public class TipoLogradouroService {
	
	@Autowired
	TipoLogradouroRepository repository;
	
	public TipoLogradouro specialFindByDescricao(String descricao) {
		TipoLogradouro tipo = repository.findByDescricao(descricao);
		if(tipo == null) {
			List<TipoLogradouro> result = repository.findByDescricaoIgnoreCase(descricao);
			if(result.isEmpty()) {
				tipo = repository.findByDescricaoIgnoreCaseWithPercent(descricao).get(0);
			} else {
				tipo = result.get(0);
			}
		}
		return tipo;
	}
}
