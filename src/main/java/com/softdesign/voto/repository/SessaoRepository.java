package com.softdesign.voto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.softdesign.voto.model.Sessao;

public interface SessaoRepository  extends CrudRepository<Sessao, Integer>{
	
	List<Sessao> findByIdAssociado(Integer idAssociado);
	
	@Query(value = "SELECT s FROM Sessao s WHERE s.idAssociado = :idAssociado and s.ativa = true")
	Sessao buscarSessaoAtiva(@Param("idAssociado") Integer idAssociado);
	
}
