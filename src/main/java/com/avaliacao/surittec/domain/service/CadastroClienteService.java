package com.avaliacao.surittec.domain.service;

import java.text.ParseException;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.MaskFormatter;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avaliacao.surittec.domain.exception.ClienteNaoEncontradoException;
import com.avaliacao.surittec.domain.exception.EntidadeEmUsoException;
import com.avaliacao.surittec.domain.model.Cliente;
import com.avaliacao.surittec.domain.model.Email;
import com.avaliacao.surittec.domain.model.Telefone;
import com.avaliacao.surittec.domain.model.TipoTelefone;
import com.avaliacao.surittec.domain.repository.ClienteRepository;
import com.example.demo.domain.service.ValidationMessage;

@Service
public class CadastroClienteService {

	private static final String MSG_Cliente_EM_USO = "Cliente de código %d não pode ser removido, pois está em uso";

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional
	public Cliente salvar(Cliente cliente) {
		cliente.setCpf(cliente.getCpf().replaceAll("\\D", ""));
		if (cliente.getEndereco() != null)
			cliente.getEndereco().setCep(cliente.getEndereco().getCep().replaceAll("\\D", ""));

		cliente.getEndereco().setCliente(cliente);
		cliente.getTelefones().forEach(telefone -> telefone.setCliente(cliente));
		cliente.getEmails().forEach(email -> email.setCliente(cliente));

		return clienteRepository.save(cliente);

	}

	@Transactional
	public void excluir(Long clienteId) {
		try {
			clienteRepository.deleteById(clienteId);
			clienteRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new ClienteNaoEncontradoException(clienteId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_Cliente_EM_USO, clienteId));
		}
	}

	public Cliente buscarOuFalhar(Long clienteId) {
		return clienteRepository.findById(clienteId).orElseThrow(() -> new ClienteNaoEncontradoException(clienteId));
	}

}
