package com.tralmeida.edza.metropolisintegracaodne.entities;

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
@Table(name = "im_statusimportacaodne")
public class StatusImportacao {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long statusImportacaoId;
	private String descricao;
	
	@OneToMany(mappedBy = "statusImportacao")
	private List<ImportacaoDNE> importacoes = new ArrayList<>();

	public StatusImportacao() {
	} 
	
	public StatusImportacao(Long id, String descricao) {
		super();
		this.statusImportacaoId = id;
		this.descricao = descricao;
	}

	public Long getStatusImportacaoId() {
		return statusImportacaoId;
	}

	public void setStatusImportacaoId(Long id) {
		this.statusImportacaoId = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ImportacaoDNE> getImportacoes() {
		return importacoes;
	}

	public void setImportacoes(List<ImportacaoDNE> importacoes) {
		this.importacoes = importacoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(statusImportacaoId, importacoes, descricao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusImportacao other = (StatusImportacao) obj;
		return Objects.equals(statusImportacaoId, other.statusImportacaoId) && Objects.equals(importacoes, other.importacoes)
				&& Objects.equals(descricao, other.descricao);
	} 
}
