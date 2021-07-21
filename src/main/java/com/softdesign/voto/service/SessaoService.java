package com.softdesign.voto.service;

import com.softdesign.voto.model.Sessao;

public interface SessaoService {
	void criarSessao(Integer idAssociado, Integer tempo);
	
	boolean validarSessao(Integer id);

	Sessao buscarSessaoValida(Integer id);
	
	void desativarSessao(Sessao sessao);
}
