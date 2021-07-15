package com.softdesign.voto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.softdesign.voto.model.Associado;
import com.softdesign.voto.model.Voto;
import com.softdesign.voto.repository.AssociadoRepository;
import com.softdesign.voto.repository.VotoReporitory;

@Service
public class VotoService {

	@Autowired
	public VotoReporitory votoDao;
	@Autowired
	public AssociadoRepository associadoDao;


	public boolean validarVoto(Voto voto) {
		boolean validadeVoto = verificarDuplicidade(voto);
		return validadeVoto;
	}
	
	public String invalidarVoto(boolean sessao,boolean voto,boolean cpf) {
		String mensagem=new String();
		if(!sessao) {
			mensagem="Sua sessão expirou! Tente novamente."; 
		}else if(!voto){
			mensagem="Não é possível votar mais de uma vez na mesma opção!"; 
		}else if(!cpf){
			mensagem="CPF inválido!"; 
		}
		return mensagem;
	}

	public boolean verificarDuplicidade(Voto voto) {

		List<Voto> listaPautas = votoDao.findByIdPauta(voto.getIdPauta());
		List<Voto> listaVotoPorAssociado = listaPautas.stream().filter(l->l.getIdAssociado()==
				voto.getIdAssociado()).collect(Collectors.toList());
		
		boolean valido = (listaVotoPorAssociado.size() > 0) ? false : true;
		return valido;
	}
	
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
