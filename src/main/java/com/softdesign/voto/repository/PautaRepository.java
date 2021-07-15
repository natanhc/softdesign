package com.softdesign.voto.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softdesign.voto.model.Pauta;
@Repository
public interface PautaRepository extends CrudRepository<Pauta, Integer>{
	List<Pauta> findByDescricao(String descricao);
}
