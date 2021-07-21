package com.softdesign.voto.service;

import com.softdesign.voto.dto.VotoDTO;
import com.softdesign.voto.model.Voto;

public interface VotoService {
	Voto create(VotoDTO requisicao);
	
	void save(VotoDTO voto);
	
	void validate(VotoDTO requisicao);

	boolean verificarDuplicidade(VotoDTO requisicao);

	boolean validarCpf(Integer idAssociado);
}
