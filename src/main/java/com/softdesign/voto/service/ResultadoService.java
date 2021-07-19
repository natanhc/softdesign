package com.softdesign.voto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.softdesign.voto.dto.AssociadoDTO;
import com.softdesign.voto.dto.OpcaoDTO;
import com.softdesign.voto.dto.PautaDTO;
import com.softdesign.voto.dto.ResultadoDTO;
import com.softdesign.voto.enums.OpcaoEnum;
import com.softdesign.voto.interfaces.IResultado;
import com.softdesign.voto.model.Associado;
import com.softdesign.voto.model.Candidato;
import com.softdesign.voto.model.Pauta;
import com.softdesign.voto.model.Voto;
import com.softdesign.voto.repository.PautaRepository;
import com.softdesign.voto.repository.VotoReporitory;

@Service
public class ResultadoService implements IResultado {

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
