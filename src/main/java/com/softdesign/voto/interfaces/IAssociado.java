package com.softdesign.voto.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.softdesign.voto.dto.AssociadoDTO;
import com.softdesign.voto.model.Associado;

public interface IAssociado {
	void save(AssociadoDTO associado);
	Associado create(AssociadoDTO requisicao);
	void validate(AssociadoDTO requisicao);
}
