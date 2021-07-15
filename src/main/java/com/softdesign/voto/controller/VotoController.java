package com.softdesign.voto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softdesign.voto.model.Voto;
import com.softdesign.voto.repository.VotoReporitory;
import com.softdesign.voto.service.VotoService;

@RestController
public class VotoController {

	@Autowired
	private VotoReporitory votoDao;

	@Autowired
	private VotoService service;
	
	@PostMapping(path="/voto")
	public ResponseEntity<?> salvarVoto(@RequestBody Voto voto){
		Integer idAssociado = voto.getIdAssociado();
		service.criarSessao(idAssociado);
		
		if(service.validarSessao(idAssociado)) {
			return new ResponseEntity<>(votoDao.save(voto),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
}
