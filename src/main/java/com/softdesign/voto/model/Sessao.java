package com.softdesign.voto.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Sessao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToMany(mappedBy = "sessao")
	private List<Associado> associado = new ArrayList<>();
	private Boolean ativa;
	private Timestamp horaInicio;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getAtiva() {
		return ativa;
	}
	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
	}
	public Timestamp getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Timestamp horaInicio) {
		this.horaInicio = horaInicio;
	}
	public List<Associado> getAssociado() {
		return associado;
	}
	public void setAssociado(List<Associado> associado) {
		this.associado = associado;
	}

	
}
