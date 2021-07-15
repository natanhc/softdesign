package com.softdesign.voto.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdesign.voto.model.Sessao;
import com.softdesign.voto.repository.SessaoRepository;

@Service
public class SessaoService {
	
	@Autowired
	public SessaoRepository sessaoDao;

	public void criarSessao(Integer idAssociado) {
		Sessao sessao = new Sessao();
		sessao.setAtiva(true);
		sessao.setIdAssociado(idAssociado);
		sessao.setHoraInicio(new Timestamp(System.currentTimeMillis()));
		sessaoDao.save(sessao);
	}

	public boolean validarSessao(Integer idAssociado) {
		Sessao sessao = buscarSessaoValida(idAssociado).get();
		Date horaInicio = sessao.getHoraInicio();
		Date horaAgora = new Date();
		int diferencaDeTempo = (int) ((horaInicio.getTime() / 60000) - (horaAgora.getTime() / 60000));
		
		boolean valido = (diferencaDeTempo < 0) ? false : true;
		desativarSessao(sessao);
		return valido;
	}

	public Optional<Sessao> buscarSessaoValida(Integer idAssociado) {
		List<Sessao> sessoes = sessaoDao.findByIdAssociado(idAssociado);
		Integer idSessao = sessoes.stream().filter(s -> s.getAtiva() == true).mapToInt(s -> s.getId()).findFirst()
				.getAsInt();
		return sessaoDao.findById(idSessao);
	}

	public void desativarSessao(Sessao sessao) {
		sessao.setAtiva(false);
		sessaoDao.save(sessao);
	}
}
