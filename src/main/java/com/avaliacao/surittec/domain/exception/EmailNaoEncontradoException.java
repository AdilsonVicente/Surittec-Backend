package com.avaliacao.surittec.domain.exception;

public class EmailNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;

	public EmailNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public EmailNaoEncontradoException(Long emailId) {
		this(String.format("Não existe um cadastro de email com código %d", emailId));
	}
	
}
