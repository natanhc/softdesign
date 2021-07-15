package com.softdesign.voto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softdesign.voto.dto.SessaoDTO;
import com.softdesign.voto.model.Associado;
import com.softdesign.voto.model.Voto;
import com.softdesign.voto.repository.VotoReporitory;
import com.softdesign.voto.service.VotoService;

@RestController
public class VotoController {

	@Autowired
	private VotoReporitory votoDao;

	@Autowired
	private VotoService service;

	@PostMapping(path = "/voto")
	public ResponseEntity<?> salvarVoto(@RequestBody Voto voto) {

		Integer idAssociado = voto.getIdAssociado();
		boolean sessaoValida = service.validarSessao(idAssociado);
		boolean votoValido = service.validarVoto(voto);

		if (sessaoValida && votoValido) {
			return new ResponseEntity<>(votoDao.save(voto), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PostMapping(path="/sessao")
	public ResponseEntity<?> criarSessao(@RequestBody SessaoDTO listaAsssociados){
		
		List<Associado> associados = listaAsssociados.getIdsAssociados().stream().map( idAssociado -> 
		new Associado(idAssociado)).collect(Collectors.toList());
		
		return null;
		
	}

}
