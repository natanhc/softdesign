package com.softdesign.voto.enums;

public enum OpcaoEnum {

	SIM("SIM"),NAO("NAO");
	
	private String valor;
	
	private OpcaoEnum(String valor) {
		this.valor=valor;
	}
	
	public String getValor() {
		return this.valor;
	}
}
