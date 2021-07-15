package com.softdesign.voto.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdesign.voto.dto.ResultadoDTO;
import com.softdesign.voto.model.Associado;
import com.softdesign.voto.model.Sessao;
import com.softdesign.voto.model.Voto;
import com.softdesign.voto.repository.PautaRepository;
import com.softdesign.voto.repository.SessaoRepository;
import com.softdesign.voto.repository.VotoReporitory;

@Service
public class VotoService {

	@Autowired
	public VotoReporitory votoDao;
	@Autowired
	public SessaoRepository sessaoDao;
	@Autowired
	private VotoService service;

	public void criarSessao(List<Integer> idAssociado) {
		Sessao sessao = new Sessao();
		Associado associado = new Associado();
		associado.setId(idAssociado);
		
		sessao.setAtiva(true);
		sessao.getAssociado().add(associado);
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
	
	public boolean validarVoto(Voto voto) {
		Integer pautas = votoDao.findByIdAssociado(voto.getIdAssociado()).size();
		if(pautas>0) {
			return false;
		};
		return true;
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
