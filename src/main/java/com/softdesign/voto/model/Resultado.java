package com.softdesign.voto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Resultado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer idPauta;
	private Integer idCandidato;
	private Integer quantidadeDeVotos;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdPauta() {
		return idPauta;
	}
	public void setIdPauta(Integer idPauta) {
		this.idPauta = idPauta;
	}
	public Integer getIdCandidato() {
		return idCandidato;
	}
	public void setIdCandidato(Integer idCandidato) {
		this.idCandidato = idCandidato;
	}
	public Integer getQuantidadeDeVotos() {
		return quantidadeDeVotos;
	}
	public void setQuantidadeDeVotos(Integer quantidadeDeVotos) {
		this.quantidadeDeVotos = quantidadeDeVotos;
	}
	
	
}
