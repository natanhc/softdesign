package com.softdesign.voto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.softdesign.voto.dto.VotoDTO;
import com.softdesign.voto.model.Associado;
import com.softdesign.voto.model.Voto;
import com.softdesign.voto.repository.AssociadoRepository;
import com.softdesign.voto.repository.VotoReporitory;
import com.softdesign.voto.service.VotoService;

@Service
public class VotoServiceImpl implements VotoService {

	@Autowired
	public VotoReporitory votoDao;
	@Autowired
	public AssociadoRepository associadoDao;
	@Autowired
	private SessaoServiceImpl sessao;

	@Override
	public Voto create(VotoDTO requisicao) {
		Voto voto = new Voto();
		voto.setIdPauta(requisicao.getIdPauta());
		voto.setIdCandidato(requisicao.getIdCandidato());
		voto.setIdAssociado(requisicao.getIdAssociado());
		voto.setResposta(requisicao.getResposta());
		return voto;
	}
	
	@Override
	public void save(VotoDTO requisicao) {
		validate(requisicao);
		Voto voto= create(requisicao);
		votoDao.save(voto);
	}

	@Override
	public void validate(VotoDTO requisicao) {
		if (requisicao.getIdPauta() == null || requisicao.getIdCandidato() == null || 
				requisicao.getIdAssociado() == null || requisicao.getResposta() == null ) {
			throw new RuntimeException("Erro ao persistir o seu voto! Verifique as informações.");
		}else if(!sessao.validarSessao(requisicao.getIdAssociado())) {
			throw new RuntimeException("Sua sessão expirou! Tente novamente.");
		}else if(!verificarDuplicidade(requisicao)) {
			throw new RuntimeException("Não é possível votar mais de uma vez na mesma opção!");
		}else if(!validarCpf(requisicao.getIdAssociado())){
			throw new RuntimeException("CPF inválido!");
		};
	}

	@Override
	public boolean verificarDuplicidade(VotoDTO requisicao) {

		List<Voto> listaVotos = votoDao.buscarVotosValidos(requisicao.getIdPauta(), requisicao.getIdAssociado());
		
		boolean valido = (listaVotos.size() > 0) ? false : true;
		return valido;
	}
	
	@Override
	public boolean validarCpf(Integer idAssociado) {
		RestTemplate restTemplate = new RestTemplate();
		Associado a = associadoDao.findById(idAssociado).get();
		String cpf = a.getCpf();
		String resultado;
		try { 
			resultado = restTemplate.getForObject("https://user-info.herokuapp.com/users/"+cpf, String.class);
			boolean valido = (resultado.contains("UNABLE_TO_VOTE")) ? false : true;
			return valido;
		}catch (Exception e) {
			return false;
		}
	}
}
