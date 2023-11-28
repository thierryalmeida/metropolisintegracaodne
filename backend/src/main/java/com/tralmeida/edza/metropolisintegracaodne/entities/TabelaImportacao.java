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
	private Long tabelaImportacaoId;
	private String nome;
	
	@OneToMany(mappedBy = "tabelaImportacao")
	private List<ImportacaoDNE> importacoes = new ArrayList<>();

	public TabelaImportacao() {
	} 
	
	public TabelaImportacao(Long id, String nome) {
		super();
		this.tabelaImportacaoId = id;
		this.nome = nome;
	}

	public Long getTabelaImportacaoId() {
		return tabelaImportacaoId;
	}

	public void setTabelaImportacaoId(Long id) {
		this.tabelaImportacaoId = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ImportacaoDNE> getImportacoes() {
		return importacoes;
	}

	public void setImportacoes(List<ImportacaoDNE> importacoes) {
		this.importacoes = importacoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tabelaImportacaoId, importacoes, nome);
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
		return Objects.equals(tabelaImportacaoId, other.tabelaImportacaoId) && Objects.equals(importacoes, other.importacoes)
				&& Objects.equals(nome, other.nome);
	} 

}
