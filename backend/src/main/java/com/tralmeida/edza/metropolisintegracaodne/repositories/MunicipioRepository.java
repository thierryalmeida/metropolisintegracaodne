package com.tralmeida.edza.metropolisintegracaodne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tralmeida.edza.metropolisintegracaodne.entities.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long>{
	
}
