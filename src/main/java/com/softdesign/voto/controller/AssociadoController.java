package com.softdesign.voto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softdesign.voto.dto.AssociadoDTO;
import com.softdesign.voto.model.Associado;
import com.softdesign.voto.repository.AssociadoRepository;
import com.softdesign.voto.service.AssociadoService;


@RestController
public class AssociadoController {

	@Autowired
	AssociadoService associado;

	@PostMapping(path="/associado")
	public void salvarNovoAssociado(@RequestBody AssociadoDTO requisicao){
		associado.save(requisicao);
	}
}
