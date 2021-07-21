package com.softdesign.voto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.softdesign.voto.model.Voto;

@Repository
public interface VotoReporitory extends CrudRepository<Voto, Integer> {
	
	List<Voto> findByIdPauta(Integer idPauta);
	
	List<Voto> findByIdAssociado(Integer idAssociado);

	@Query(value = "SELECT v FROM Voto v WHERE v.idPauta = :idPauta and v.idAssociado = :idAssociado")
	List<Voto> buscarVotosValidos(
			@Param("idPauta") Integer idPauta,
			@Param("idAssociado") Integer idAssociado);
	
}
