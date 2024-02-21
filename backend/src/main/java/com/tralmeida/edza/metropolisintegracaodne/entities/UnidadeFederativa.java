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
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "cg_uf")
public class UnidadeFederativa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@TableGenerator(name = "seq_metropolis", table = "seq_block",
			pkColumnName = "name", valueColumnName = "idx", pkColumnValue = "public.cg_uf.ufId",
			initialValue = 0, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "seq_metropolis")
	private Long ufId;
	
	private String sigla;
	private String nome;
	private Integer oficial;
	private Long cepIni;
	private Long cepFim;
	private Timestamp dtInclusao;
	private Timestamp dtAtualizacao;
	
	@ManyToOne
	@JoinColumn(name = "importacaodneid")
	private ImportacaoDNE importacaoDNE;
	
	@ManyToOne
	@JoinColumn(name = "paisid")
	private Pais pais;
	
	public UnidadeFederativa() {
	}
	
	public UnidadeFederativa(Long ufId, String sigla, String nome, Integer oficial, Long cepIni, Long cepFim,
			Pais pais) {
		super();
		this.ufId = ufId;
		this.sigla = sigla;
		this.nome = nome;
		this.oficial = oficial;
		this.cepIni = cepIni;
		this.cepFim = cepFim;
		this.pais = pais;
	}

	public Long getUfId() {
		return ufId;
	}

	public void setUfId(Long ufId) {
		this.ufId = ufId;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getOficial() {
		return oficial;
	}

	public void setOficial(Integer oficial) {
		this.oficial = oficial;
	}

	public Long getCepIni() {
		return cepIni;
	}

	public void setCepIni(Long cepIni) {
		this.cepIni = cepIni;
	}

	public Long getCepFim() {
		return cepFim;
	}

	public void setCepFim(Long cepFim) {
		this.cepFim = cepFim;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Timestamp getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(Timestamp dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public Timestamp getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(Timestamp dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

	public ImportacaoDNE getImportacaoDNE() {
		return importacaoDNE;
	}

	public void setImportacaoDNE(ImportacaoDNE importacaoDNE) {
		this.importacaoDNE = importacaoDNE;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sigla, ufId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeFederativa other = (UnidadeFederativa) obj;
		return Objects.equals(sigla, other.sigla);
	}

}
