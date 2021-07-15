package com.softdesign.voto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softdesign.voto.model.Candidato;

@Repository
public interface CandidatoRepository extends CrudRepository<Candidato, Integer>{
	List<Candidato> findByIdPauta(Integer idPauta);
}
