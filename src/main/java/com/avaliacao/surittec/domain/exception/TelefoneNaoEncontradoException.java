package com.avaliacao.surittec.domain.exception;

public class TelefoneNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;

	public TelefoneNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public TelefoneNaoEncontradoException(Long telefonceId) {
		this(String.format("Não existe um cadastro de telefone com código %d", telefonceId));
	}
}
