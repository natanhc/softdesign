package com.softdesign.voto.interfaces;

import com.softdesign.voto.dto.PautaDTO;
import com.softdesign.voto.model.Pauta;

public interface IPauta {
	void save(PautaDTO pauta);
	Pauta create(PautaDTO requisicao);
	void validate(PautaDTO requisicao);

}
