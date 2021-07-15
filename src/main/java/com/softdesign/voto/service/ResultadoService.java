package com.softdesign.voto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdesign.voto.dto.OpcaoDTO;
import com.softdesign.voto.dto.ResultadoDTO;
import com.softdesign.voto.enums.OpcaoEnum;
import com.softdesign.voto.model.Candidato;
import com.softdesign.voto.model.Pauta;
import com.softdesign.voto.model.Voto;
import com.softdesign.voto.repository.VotoReporitory;

@Service
public class ResultadoService {

	@Autowired
	public VotoReporitory votoDao;
	
	public List<ResultadoDTO> obterResultado(Integer idPauta){
		List<Voto> lista = votoDao.findByIdPauta(idPauta);
		List<ResultadoDTO> resultados = new ArrayList<>();

		//Pro código ficar mais limpo e ser mais fácil de implementar
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

	public boolean filtrarPorOpcao(Voto voto, OpcaoEnum opcao) {
		return voto.getResposta()!=null && voto.getResposta().equals(opcao.getValor());
	}
}
