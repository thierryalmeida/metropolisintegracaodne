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
	private Long importacaoId;
	private String descricao;
	private Timestamp dataImportacao;
	private Long registrosLidos;
	private Long registrosImportados;
	private Long registrosLidosComErro;
	private String logErro;
	
	@ManyToOne
	@JoinColumn(name = "statusimportacaoid")
	private StatusImportacao statusImportacao;
	
	@ManyToOne
	@JoinColumn(name = "tabelaimportacaoid")
	private TabelaImportacao tabelaImportacao;
	
	public ImportacaoDNE() {
	}

	public ImportacaoDNE(Long id, String descricao, Timestamp dataImportacao, 
			TabelaImportacao tabelaImportacao, StatusImportacao statusImportacao) {
		super();
		this.importacaoId = id;
		this.descricao = descricao;
		this.dataImportacao = dataImportacao;
		this.tabelaImportacao = tabelaImportacao;
		this.statusImportacao = statusImportacao;
	}

	public Long getImportacaoId() {
		return importacaoId;
	}

	public void setImportacaoId(Long id) {
		this.importacaoId = id;
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

	public Long getRegistrosLidos() {
		return registrosLidos;
	}

	public void setRegistrosLidos(Long registrosLidos) {
		this.registrosLidos = registrosLidos;
	}

	public Long getRegistrosImportados() {
		return registrosImportados;
	}

	public void setRegistrosImportados(Long registrosImportados) {
		this.registrosImportados = registrosImportados;
	}

	public StatusImportacao getStatusImportacao() {
		return statusImportacao;
	}

	public void setStatusImportacao(StatusImportacao statusImportacao) {
		this.statusImportacao = statusImportacao;
	}

	public Long getRegistrosLidosComErro() {
		return registrosLidosComErro;
	}

	public void setRegistrosLidosComErro(Long registrosLidosComErro) {
		this.registrosLidosComErro = registrosLidosComErro;
	}
	
	public String getLogErro() {
		return logErro;
	}

	public void setLogErro(String logErro) {
		this.logErro = logErro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(importacaoId);
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
		return Objects.equals(importacaoId, other.importacaoId);
	}
}
