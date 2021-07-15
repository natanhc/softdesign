package com.softdesign.voto.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softdesign.voto.model.Candidato;
import com.softdesign.voto.model.Voto;

@Repository
public interface VotoReporitory extends CrudRepository<Voto, Integer> {
	List<Voto> findByIdPauta(Integer idPauta);
	List<Voto> findByIdAssociado(Integer idAssociado);
}
