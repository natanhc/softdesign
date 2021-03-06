package com.softdesign.voto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdesign.voto.dto.AssociadoDTO;
import com.softdesign.voto.model.Associado;
import com.softdesign.voto.repository.AssociadoRepository;
import com.softdesign.voto.service.AssociadoService;

@Service
public class AssociadoServiceImpl implements AssociadoService {

	@Autowired
	private AssociadoRepository associadoDao;

	@Override
	public void save(AssociadoDTO requisicao) {
		validate(requisicao);
		Associado associado = create(requisicao);
		associadoDao.save(associado);
	}

	@Override
	public Associado create(AssociadoDTO requisicao) {
		Associado associado = new Associado();
		associado.setNome(requisicao.getNome());
		associado.setCpf(requisicao.getCpf());
		return associado;
	}

	@Override
	public void validate(AssociadoDTO requisicao) {
		if (requisicao.getNome().isEmpty() || requisicao.getCpf().isEmpty()) {
			throw new RuntimeException("Erro ao persistir o novo associado! Verifique as informações.");
		}
	}

}
