package com.softdesign.voto.interfaces;

import java.util.Optional;

import com.softdesign.voto.model.Sessao;

public interface ISessao {
	void criarSessao(Integer idAssociado, Integer tempo);
	
	boolean validarSessao(Integer id);

	Optional<Sessao> buscarSessaoValida(Integer id);
	
	void desativarSessao(Sessao sessao);
}
