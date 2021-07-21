package com.softdesign.voto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.softdesign.voto.dto.PautaDTO;
import com.softdesign.voto.model.Pauta;
import com.softdesign.voto.repository.PautaRepository;
import com.softdesign.voto.service.PautaService;

@Service
public class PautaServiceImpl implements PautaService{
	@Autowired
	public PautaRepository pautaDao;

	@Override
	public void save(@RequestBody PautaDTO requisicao) {
		validate(requisicao);
		Pauta pauta = create(requisicao);
		pautaDao.save(pauta);
	}

	@Override
	public Pauta create(PautaDTO requisicao) {
		Pauta pauta = new Pauta();
		pauta.setDescricao(requisicao.getDescricao());
		return pauta;
	}
	
	@Override
	public void validate(PautaDTO requisicao) {
		if (requisicao.getDescricao().isEmpty()) {
			throw new RuntimeException("Erro ao persistir a pauta dessa eleição! Verifique as informações.");
		}
	}
}
