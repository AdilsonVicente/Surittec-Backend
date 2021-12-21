package com.avaliacao.surittec.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avaliacao.surittec.domain.exception.EntidadeEmUsoException;
import com.avaliacao.surittec.domain.exception.GrupoNaoEncontradoException;
import com.avaliacao.surittec.domain.exception.TelefoneNaoEncontradoException;
import com.avaliacao.surittec.domain.model.Telefone;
import com.avaliacao.surittec.domain.repository.TelefoneRepository;

@Service
public class CadastroTelefoneService {

	private static final String MSG_TELEFONE_EM_USO = "Telefone de código %d não pode ser removido, pois está em uso";

	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Transactional
	public Telefone salvar(Telefone telefone) {
		return telefoneRepository.save(telefone);
	}
	
	@Transactional
	public void excluir(Long telefoneId) {
		try {
			telefoneRepository.deleteById(telefoneId);
			telefoneRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new GrupoNaoEncontradoException(telefoneId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_TELEFONE_EM_USO, telefoneId));
		}
	}
	
	public Telefone buscarOuFalhar(Long telefoneId) {
		return telefoneRepository.findById(telefoneId).orElseThrow(() -> new TelefoneNaoEncontradoException(telefoneId));
	}
}
