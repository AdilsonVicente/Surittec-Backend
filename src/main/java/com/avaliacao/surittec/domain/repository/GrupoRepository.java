package com.avaliacao.surittec.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avaliacao.surittec.domain.model.Grupo;


@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{

}
