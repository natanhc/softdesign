package com.softdesign.voto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softdesign.voto.model.Associado;

@Repository
public interface AssociadoRepository extends CrudRepository<Associado, Integer>{

}