package com.avaliacao.surittec.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.surittec.api.assembler.EmailInputDisassembler;
import com.avaliacao.surittec.api.assembler.EmailModelAssembler;
import com.avaliacao.surittec.api.model.EmailModel;
import com.avaliacao.surittec.api.model.input.EmailInput;
import com.avaliacao.surittec.domain.model.Email;
import com.avaliacao.surittec.domain.repository.EmailRepository;
import com.avaliacao.surittec.domain.service.CadastroEmailService;

@RestController
@RequestMapping(value = "/emails")
public class EmailController {

	@Autowired
	private CadastroEmailService cadastroEmailService;
	
	@Autowired
	
	private EmailRepository emailRepository;
	
	@Autowired
	private EmailModelAssembler emailModelAssembler;
	
	@Autowired
	private EmailInputDisassembler emailInputDisassembler;
	
	@GetMapping
	public List<EmailModel> listar(){
		List<Email> todosEmails = emailRepository.findAll();
		return emailModelAssembler.toCollectModel(todosEmails);
	}
	
	@GetMapping("/{emailId}")
	public EmailModel buscar(@PathVariable Long emailId) {
		Email email = cadastroEmailService.buscarOuFalhar(emailId);
		
		return emailModelAssembler.toModel(email);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EmailModel adicionar(@Valid @RequestBody EmailInput emailInput) {
		Email email = emailInputDisassembler.toDomainObject(emailInput);
		
		return emailModelAssembler.toModel(cadastroEmailService.salvar(email));
	}
	
	@PutMapping("/{emailId}")
	public EmailModel atualizar(@Valid @RequestBody EmailInput emailInput, @PathVariable Long emailId) {
		Email emailAtual = cadastroEmailService.buscarOuFalhar(emailId);
		
		emailInputDisassembler.copyToDomainObject(emailAtual, emailInput);
		
		return emailModelAssembler.toModel(cadastroEmailService.salvar(emailAtual));
		
	}
	
	@DeleteMapping("/{emailId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long emailId) {
		cadastroEmailService.excluir(emailId);
	}
	
}
