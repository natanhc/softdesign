package com.softdesign.voto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softdesign.voto.dto.ResultadoDTO;
import com.softdesign.voto.model.Pauta;
import com.softdesign.voto.repository.PautaRepository;
import com.softdesign.voto.service.ResultadoService;

@RestController
public class PautaController {

	@Autowired
	private PautaRepository pautaDao;
	@Autowired
	private ResultadoService resultado;
	
	@PostMapping(path="/pauta")
	public ResponseEntity<?> salvarNovaPauta(@RequestBody Pauta pauta){
		return new ResponseEntity<>(pautaDao.save(pauta),HttpStatus.OK);
	}
	
	@GetMapping(path="/resultado")
	public List<ResultadoDTO> obterResultado(@RequestParam Integer idPauta){
		return resultado.obterResultado(idPauta);
	}
}
