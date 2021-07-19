package com.softdesign.voto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softdesign.voto.dto.PautaDTO;
import com.softdesign.voto.dto.ResultadoDTO;
import com.softdesign.voto.service.PautaService;
import com.softdesign.voto.service.ResultadoService;

@RestController
public class PautaController {

	@Autowired
	private PautaService pauta;

	@Autowired
	private ResultadoService resultado;
	
	@PostMapping(path="/pauta")
	public void salvarNovaPauta(@RequestBody PautaDTO requisicao){
		pauta.save(requisicao);
	}
	
	@GetMapping(path="/resultado")
	public List<ResultadoDTO> obterResultado(@RequestParam Integer idPauta){
		return resultado.obterResultado(idPauta);
	}
}
