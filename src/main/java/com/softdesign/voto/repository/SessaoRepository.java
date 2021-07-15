package com.softdesign.voto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.softdesign.voto.model.Sessao;
import com.softdesign.voto.model.Voto;

public interface SessaoRepository  extends CrudRepository<Sessao, Integer>{
	List<Sessao> findByIdAssociado(Integer idAssociado);
}
