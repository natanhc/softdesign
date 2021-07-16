package com.softdesign.voto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softdesign.voto.model.Associado;
import com.softdesign.voto.repository.AssociadoRepository;


@RestController
public class AssociadoController {

	@Autowired
	private AssociadoRepository associadoDao;
	
	@PostMapping(path="/associado")
	public ResponseEntity<?> salvarNovoAssociado(@RequestBody Associado associado){
		return new ResponseEntity<>(associadoDao.save(associado),HttpStatus.OK);
	}
}
