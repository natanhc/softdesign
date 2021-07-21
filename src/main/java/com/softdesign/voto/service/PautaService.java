package com.softdesign.voto.service;

import com.softdesign.voto.dto.PautaDTO;
import com.softdesign.voto.model.Pauta;

public interface PautaService {
	
	void save(PautaDTO pauta);
	
	Pauta create(PautaDTO requisicao);
	
	void validate(PautaDTO requisicao);

}
