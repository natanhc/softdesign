package com.softdesign.voto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softdesign.voto.model.Voto;
import com.softdesign.voto.repository.VotoReporitory;
import com.softdesign.voto.service.SessaoService;
import com.softdesign.voto.service.VotoService;

@RestController
public class VotoController {

	@Autowired
	private VotoReporitory votoDao;

	@Autowired
	private VotoService votoService;
	@Autowired
	private SessaoService sessaoService;
	
	@PostMapping(path="/voto")
	public ResponseEntity<?> salvarVoto(@RequestBody Voto voto){
//		sessaoService.criarSessao(voto.getIdAssociado(),60000);
		
		boolean sessaoValida = sessaoService.validarSessao(voto.getIdAssociado());
		boolean votoValido =  votoService.validarVoto(voto);
		boolean cpfValido =  votoService.validarCpf(voto.getIdAssociado());
		
		if(sessaoValida && votoValido && cpfValido) {
			votoDao.save(voto);
			return new ResponseEntity<>("Voto computado com sucesso!",HttpStatus.OK);
		}else {
			String mensagem = votoService.invalidarVoto(sessaoValida,votoValido,cpfValido);
			return new ResponseEntity<>(mensagem,HttpStatus.FORBIDDEN);
		}
	}
}
