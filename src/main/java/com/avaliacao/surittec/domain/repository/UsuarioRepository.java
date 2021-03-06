package com.avaliacao.surittec.domain.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.avaliacao.surittec.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long>{

	Optional<Usuario> findByNome(String nome);
}
