package com.avaliacao.surittec.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avaliacao.surittec.domain.exception.EmailNaoEncontradoException;
import com.avaliacao.surittec.domain.exception.EntidadeEmUsoException;
import com.avaliacao.surittec.domain.exception.GrupoNaoEncontradoException;
import com.avaliacao.surittec.domain.model.Email;
import com.avaliacao.surittec.domain.repository.EmailRepository;

@Service
public class CadastroEmailService {

	private static final String MSG_EMAIL_EM_USO = "Email de código %d não pode ser removido, pois está em uso";

	@Autowired
	private EmailRepository emailRepository;
	
	@Transactional
	public Email salvar(Email email) {
		return emailRepository.save(email);
	}
	
	@Transactional
	public void excluir(Long emailId) {
		try {
			emailRepository.deleteById(emailId);
			emailRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new GrupoNaoEncontradoException(emailId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_EMAIL_EM_USO, emailId));
		}
	}
	
	public Email buscarOuFalhar(Long emailId) {
		return emailRepository.findById(emailId).orElseThrow(() -> new EmailNaoEncontradoException(emailId));
	}
}
