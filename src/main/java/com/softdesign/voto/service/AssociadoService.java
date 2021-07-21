package com.softdesign.voto.service;

import com.softdesign.voto.dto.AssociadoDTO;
import com.softdesign.voto.model.Associado;

public interface AssociadoService {
	
	void save(AssociadoDTO associado);
	
	Associado create(AssociadoDTO requisicao);
	
	void validate(AssociadoDTO requisicao);
}
