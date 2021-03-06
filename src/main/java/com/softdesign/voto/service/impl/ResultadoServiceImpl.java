package com.softdesign.voto.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdesign.voto.dto.OpcaoDTO;
import com.softdesign.voto.dto.ResultadoDTO;
import com.softdesign.voto.enumeration.OpcaoEnum;
import com.softdesign.voto.model.Voto;
import com.softdesign.voto.repository.VotoReporitory;
import com.softdesign.voto.service.ResultadoService;

@Service
public class ResultadoServiceImpl implements ResultadoService {

	@Autowired
	public VotoReporitory votoDao;

	@Override
	public List<ResultadoDTO> obterResultado(Integer idPauta) {
			List<Voto> lista = votoDao.findByIdPauta(idPauta);
			List<ResultadoDTO> resultados = new ArrayList<>();

			Map<Integer, List<Voto>> votosPorCandidato = lista.stream().collect(Collectors.groupingBy(Voto::getIdCandidato));
			
			for (Map.Entry<Integer, List<Voto>> listaVotos : votosPorCandidato.entrySet()) {
				ResultadoDTO resultado = new ResultadoDTO();
				resultado.setCandidato(listaVotos.getKey());
				
				OpcaoDTO opcao = new OpcaoDTO();
				opcao.setSim(listaVotos.getValue().stream().filter(
						voto->filtrarPorOpcao(voto,OpcaoEnum.SIM)).collect(Collectors.counting()).intValue());
				opcao.setNao(listaVotos.getValue().stream().filter(
						voto->filtrarPorOpcao(voto,OpcaoEnum.NAO)).collect(Collectors.counting()).intValue());
				resultado.setOpcao(opcao);
				resultados.add(resultado);
			}
			return resultados;
	}

	@Override
	public boolean filtrarPorOpcao(Voto voto, OpcaoEnum opcao) {
		return voto.getResposta() != null && voto.getResposta().equals(opcao.getValor());
	}
}
