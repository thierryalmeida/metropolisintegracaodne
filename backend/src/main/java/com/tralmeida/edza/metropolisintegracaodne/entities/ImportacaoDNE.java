package com.tralmeida.edza.metropolisintegracaodne.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "im_importacaodne")
public class ImportacaoDNE implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private Timestamp dataImportacao;
	
	@ManyToOne
	@JoinColumn(name = "tabelaimportacaoid")
	private TabelaImportacao tabelaImportacao;
	
	public ImportacaoDNE() {
	}

	public ImportacaoDNE(Long id, String descricao, Timestamp dataImportacao, TabelaImportacao tabelaImportacao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataImportacao = dataImportacao;
		this.tabelaImportacao = tabelaImportacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Timestamp getDataImportacao() {
		return dataImportacao;
	}

	public void setDataImportacao(Timestamp dataImportacao) {
		this.dataImportacao = dataImportacao;
	}

	public TabelaImportacao getTabelaImportacao() {
		return tabelaImportacao;
	}

	public void setTabelaImportacao(TabelaImportacao tabelaImportacao) {
		this.tabelaImportacao = tabelaImportacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImportacaoDNE other = (ImportacaoDNE) obj;
		return Objects.equals(id, other.id);
	}
	
}
