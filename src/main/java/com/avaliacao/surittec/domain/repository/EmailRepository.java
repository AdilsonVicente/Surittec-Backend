package com.avaliacao.surittec.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avaliacao.surittec.domain.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{

}
