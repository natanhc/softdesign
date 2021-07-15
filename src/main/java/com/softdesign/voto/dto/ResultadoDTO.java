package com.softdesign.voto.dto;

public class ResultadoDTO {
	private Integer candidato;
	private OpcaoDTO opcao;
	
	public Integer getCandidato() {
		return candidato;
	}
	public void setCandidato(Integer candidato) {
		this.candidato = candidato;
	}
	public OpcaoDTO getOpcao() {
		return opcao;
	}
	public void setOpcao(OpcaoDTO opcao) {
		this.opcao = opcao;
	}
	
}
