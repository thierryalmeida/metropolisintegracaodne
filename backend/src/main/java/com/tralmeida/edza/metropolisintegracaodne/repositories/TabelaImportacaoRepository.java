package com.tralmeida.edza.metropolisintegracaodne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tralmeida.edza.metropolisintegracaodne.entities.TabelaImportacao;

@Repository
public interface TabelaImportacaoRepository extends JpaRepository<TabelaImportacao, Long>{

}
