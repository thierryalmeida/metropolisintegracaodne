package com.tralmeida.edza.metropolisintegracaodne.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tralmeida.edza.metropolisintegracaodne.entities.TipoLogradouro;

@Repository
public interface TipoLogradouroRepository extends JpaRepository<TipoLogradouro, Long>{
	
	TipoLogradouro findByDescricao(String descricao);
	
	@Query(value = "SELECT * from cg_tipologradouro tl where UPPER(tl.descricao) like UPPER(:descricao)", 
			nativeQuery = true)
	List<TipoLogradouro> findByDescricaoIgnoreCase(String descricao);
	
	@Query(value = "SELECT * from cg_tipologradouro tl where UPPER(tl.descricao) like UPPER(%:descricao%)", 
			nativeQuery = true)
	List<TipoLogradouro> findByDescricaoIgnoreCaseWithPercent(String descricao);
}
