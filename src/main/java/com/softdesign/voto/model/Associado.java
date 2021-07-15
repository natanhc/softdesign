package com.softdesign.voto.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class Associado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	@ManyToMany
	@JoinTable(name = "sessao", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id_associado"))
	private List<Sessao> sessao;

	public Associado(Integer idAssociado) {
		this.id = idAssociado;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
