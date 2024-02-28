package com.tralmeida.edza.metropolisintegracaodne.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.tralmeida.edza.metropolisintegracaodne.entities.Municipio;
import com.tralmeida.edza.metropolisintegracaodne.entities.UnidadeFederativa;

public class MunicipioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long municipioId;
	
	private String nome;
	private Long codigo;
	private Long cep;
	private Integer oficial;
	private Long cepInicial;
	private Long cepFinal;
	private Long codigoTom;
	private Timestamp dtInclusao;
	private Timestamp dtAtualizacao;
	
	private Long importacaoId;
	
	private UnidadeFederativaDTO uf;
	
	public MunicipioDTO() {
	}
	
	public MunicipioDTO(Municipio entity) {
		this.municipioId = entity.getMunicipioId();
		this.nome = entity.getNome();
		this.codigo = entity.getCodigo();
		this.cep = entity.getCep();
		this.oficial = entity.getOficial();
		this.cepInicial = entity.getCepInicial();
		this.cepFinal = entity.getCepFinal();
		this.codigoTom = entity.getCodigoTom();
		this.uf = new UnidadeFederativaDTO(entity.getUf());
	}
	
	public MunicipioDTO(Long municipioId, String nome, Long codigo, Long cep, Integer oficial, Long cepInicial,
			Long cepFinal, Long codigoTom, UnidadeFederativaDTO uf) {
		super();
		this.municipioId = municipioId;
		this.nome = nome;
		this.codigo = codigo;
		this.cep = cep;
		this.oficial = oficial;
		this.cepInicial = cepInicial;
		this.cepFinal = cepFinal;
		this.codigoTom = codigoTom;
		this.uf = uf;
	}

	public Long getMunicipioId() {
		return municipioId;
	}

	public void setMunicipioId(Long municipioId) {
		this.municipioId = municipioId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public Integer getOficial() {
		return oficial;
	}

	public void setOficial(Integer oficial) {
		this.oficial = oficial;
	}

	public Long getCepInicial() {
		return cepInicial;
	}

	public void setCepInicial(Long cepInicial) {
		this.cepInicial = cepInicial;
	}

	public Long getCepFinal() {
		return cepFinal;
	}

	public void setCepFinal(Long cepFinal) {
		this.cepFinal = cepFinal;
	}

	public Long getCodigoTom() {
		return codigoTom;
	}

	public void setCodigoTom(Long codigoTom) {
		this.codigoTom = codigoTom;
	}

	public UnidadeFederativaDTO getUf() {
		return uf;
	}

	public void setUf(UnidadeFederativaDTO uf) {
		this.uf = uf;
	}

	public Long getImportacaoId() {
		return importacaoId;
	}

	public void setImportacaoId(Long importacaoId) {
		this.importacaoId = importacaoId;
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
}
