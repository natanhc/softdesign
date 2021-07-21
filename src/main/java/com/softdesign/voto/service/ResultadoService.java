package com.softdesign.voto.service;

import java.util.List;

import com.softdesign.voto.dto.ResultadoDTO;
import com.softdesign.voto.enumeration.OpcaoEnum;
import com.softdesign.voto.model.Voto;

public interface ResultadoService {
	
	List<ResultadoDTO> obterResultado(Integer id);
	
	boolean filtrarPorOpcao(Voto voto, OpcaoEnum opcao);
	
}
