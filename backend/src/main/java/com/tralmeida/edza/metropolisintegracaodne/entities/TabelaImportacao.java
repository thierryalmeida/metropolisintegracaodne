package com.tralmeida.edza.metropolisintegracaodne.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "im_tabelaimportacaodne")
public class TabelaImportacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeTabela;
	
	@OneToMany(mappedBy = "tabelaImportacao")
	private List<ImportacaoDNE> importacoes = new ArrayList<>();

	public TabelaImportacao() {
	} 
	
	public TabelaImportacao(Long id, String nomeTabela, List<ImportacaoDNE> importacoes) {
		super();
		this.id = id;
		this.nomeTabela = nomeTabela;
		this.importacoes = importacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

	public List<ImportacaoDNE> getImportacoes() {
		return importacoes;
	}

	public void setImportacoes(List<ImportacaoDNE> importacoes) {
		this.importacoes = importacoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, importacoes, nomeTabela);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TabelaImportacao other = (TabelaImportacao) obj;
		return Objects.equals(id, other.id) && Objects.equals(importacoes, other.importacoes)
				&& Objects.equals(nomeTabela, other.nomeTabela);
	} 

}
