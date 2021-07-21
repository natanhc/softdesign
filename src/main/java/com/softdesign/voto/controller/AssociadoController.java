package com.softdesign.voto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softdesign.voto.dto.AssociadoDTO;
import com.softdesign.voto.service.impl.AssociadoServiceImpl;


@RestController
public class AssociadoController {

	@Autowired
	AssociadoServiceImpl associado;

	@PostMapping(path="/associado")
	public void salvarNovoAssociado(@RequestBody AssociadoDTO requisicao){
		associado.save(requisicao);
	}
}
