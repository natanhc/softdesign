package com.softdesign.voto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softdesign.voto.dto.VotoDTO;
import com.softdesign.voto.model.Voto;
import com.softdesign.voto.repository.VotoReporitory;
import com.softdesign.voto.service.SessaoService;
import com.softdesign.voto.service.VotoService;

@RestController
public class VotoController {

	@Autowired
	private VotoService voto;
	
	@PostMapping(path="/voto")
	public void salvarVoto(@RequestBody VotoDTO requisicao){
		voto.save(requisicao);
	}
}
