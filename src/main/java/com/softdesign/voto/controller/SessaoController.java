package com.softdesign.voto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softdesign.voto.model.Sessao;
import com.softdesign.voto.service.SessaoService;

@RestController
public class SessaoController {

	@Autowired
	private SessaoService sessaoService;

	@GetMapping(path="/criarSessao")
	public void criarSessao(@RequestParam Integer idAssociado, Integer tempo){
		sessaoService.criarSessao(idAssociado,tempo);
	}
	
	@GetMapping(path="/encerrarSessao")
	public void encerrarSessao(@RequestParam Sessao sessao){
		sessaoService.desativarSessao(sessao);
	}
}
