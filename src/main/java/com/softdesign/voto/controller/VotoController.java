package com.softdesign.voto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softdesign.voto.dto.VotoDTO;
import com.softdesign.voto.service.impl.VotoServiceImpl;

@RestController
public class VotoController {

	@Autowired
	private VotoServiceImpl voto;
	
	@PostMapping(path="/voto")
	public void salvarVoto(@RequestBody VotoDTO requisicao){
		voto.save(requisicao);
	}
}
