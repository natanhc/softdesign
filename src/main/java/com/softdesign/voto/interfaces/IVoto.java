package com.softdesign.voto.interfaces;

import com.softdesign.voto.dto.AssociadoDTO;
import com.softdesign.voto.dto.VotoDTO;
import com.softdesign.voto.model.Associado;
import com.softdesign.voto.model.Voto;

public interface IVoto {
	Voto create(VotoDTO requisicao);
	
	void save(VotoDTO voto);
	
	void validate(VotoDTO requisicao);

	boolean verificarDuplicidade(VotoDTO requisicao);

	boolean validarCpf(Integer idAssociado);
}
