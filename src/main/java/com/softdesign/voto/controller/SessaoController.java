package com.softdesign.voto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softdesign.voto.service.impl.SessaoServiceImpl;

@RestController
public class SessaoController {

	@Autowired
	private SessaoServiceImpl sessaoService;

	@GetMapping(path="/criarSessao")
	public void criarSessao(@RequestParam Integer idAssociado, Integer tempo){
		sessaoService.criarSessao(idAssociado,tempo);
	}
	
}
