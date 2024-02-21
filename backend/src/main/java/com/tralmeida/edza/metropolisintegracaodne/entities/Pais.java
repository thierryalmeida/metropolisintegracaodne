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
@Table(name = "cg_pais")
public class Pais implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@TableGenerator(name = "seq_metropolis", table = "seq_block",
			pkColumnName = "name", valueColumnName = "idx", pkColumnValue = "public.cg_pais.paisId",
			initialValue = 0, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "seq_metropolis")
	private Long paisId;
	
	private Long codigo;
	private String sigla;
	private String nome;
	private String nacionalidade;
	private Timestamp dtInclusao;
	private Timestamp dtAtualizacao;
	
	@ManyToOne
	@JoinColumn(name = "importacaodneid")
	private ImportacaoDNE importacaoDNE;
	
	public Pais() {
	}
	
	public Pais(Long paisId, String sigla, String nome, String nacionalidade) {
		super();
		this.paisId = paisId;
		this.sigla = sigla;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
	}

	public Long getPaisId() {
		return paisId;
	}

	public void setPaisId(Long paisId) {
		this.paisId = paisId;
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

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
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
		return Objects.hash(sigla);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(sigla, other.sigla);
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
