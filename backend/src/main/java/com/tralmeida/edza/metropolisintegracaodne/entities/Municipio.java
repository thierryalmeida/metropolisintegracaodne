package com.tralmeida.edza.metropolisintegracaodne.entities;

import java.io.Serializable;
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
@Table(name = "cg_municipio")
public class Municipio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long municipioId;
	
	private String nome;
	private Long codigo;
	private Long cep;
	private Integer oficial;
	
	private Long cepInicial;
	private Long cepFinal;
	private Long codigoTom;
	
	@ManyToOne
	@JoinColumn(name = "ufid")
	private UnidadeFederativa uf;
	
	public Municipio() {
	}

	public Municipio(Long municipioId, String nome, Long codigo, Long cep, Integer oficial, Long cepInicial,
			Long cepFinal, Long codigoTom, UnidadeFederativa uf) {
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

	public UnidadeFederativa getUf() {
		return uf;
	}

	public void setUf(UnidadeFederativa uf) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(municipioId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Municipio other = (Municipio) obj;
		return Objects.equals(municipioId, other.municipioId);
	}
}
