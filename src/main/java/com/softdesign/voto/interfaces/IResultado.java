package com.softdesign.voto.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.softdesign.voto.dto.AssociadoDTO;
import com.softdesign.voto.dto.PautaDTO;
import com.softdesign.voto.dto.ResultadoDTO;
import com.softdesign.voto.enums.OpcaoEnum;
import com.softdesign.voto.model.Associado;
import com.softdesign.voto.model.Voto;

public interface IResultado {
	
	List<ResultadoDTO> obterResultado(Integer id);
	
	boolean filtrarPorOpcao(Voto voto, OpcaoEnum opcao);
	
}
