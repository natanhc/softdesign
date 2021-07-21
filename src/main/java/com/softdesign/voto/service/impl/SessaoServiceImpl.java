package com.softdesign.voto.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdesign.voto.model.Sessao;
import com.softdesign.voto.repository.SessaoRepository;
import com.softdesign.voto.service.SessaoService;

@Service
public class SessaoServiceImpl implements SessaoService{
	
	@Autowired
	public SessaoRepository sessaoDao;

	@Override
	public void criarSessao(Integer idAssociado, Integer tempo) {
		Sessao sessao = new Sessao();
		sessao.setAtiva(true);
		sessao.setIdAssociado(idAssociado);
		sessao.setTempo(tempo);
		sessao.setHoraInicio(new Timestamp(System.currentTimeMillis()));
		sessaoDao.save(sessao);
	}

	@Override
	public boolean validarSessao(Integer idAssociado) {
		try {
			Sessao sessao = buscarSessaoValida(idAssociado);
			Date horaInicio = sessao.getHoraInicio();
			Integer tempo = sessao.getTempo();
			Date horaAgora = new Date();
			int diferencaDeTempo = (int) ((horaInicio.getTime() / tempo) - (horaAgora.getTime() / tempo));
			
			boolean valido = (diferencaDeTempo < 0) ? false : true;
			desativarSessao(sessao);
			return valido;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Sessao buscarSessaoValida(Integer idAssociado) {
		return sessaoDao.buscarSessaoAtiva(idAssociado);
	}

	@Override
	public void desativarSessao(Sessao sessao) {
		sessao.setAtiva(false);
		sessaoDao.save(sessao);
	}
}
