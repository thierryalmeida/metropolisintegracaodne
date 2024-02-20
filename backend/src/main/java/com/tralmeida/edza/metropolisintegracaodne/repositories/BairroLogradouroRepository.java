package com.tralmeida.edza.metropolisintegracaodne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tralmeida.edza.metropolisintegracaodne.entities.BairroLogradouro;

@Repository
public interface BairroLogradouroRepository extends JpaRepository<BairroLogradouro, Long>{
	
	@Query(value = "SELECT * from cg_bairrologradouro bl WHERE bl.bairroid = :bairroId AND bl.logradouroid = :logradouroId",
			nativeQuery = true)
	BairroLogradouro findByBairroAndLogradouro(Long bairroId, Long logradouroId);
}
