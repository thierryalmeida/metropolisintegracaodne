package com.tralmeida.edza.metropolisintegracaodne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tralmeida.edza.metropolisintegracaodne.entities.UnidadeFederativa;

@Repository
public interface UnidadeFederativaRepository extends JpaRepository<UnidadeFederativa, Long>{
	
	UnidadeFederativa findBySigla(String sigla);
}
