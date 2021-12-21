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

import com.avaliacao.surittec.api.assembler.TelefoneInputDisassembler;
import com.avaliacao.surittec.api.assembler.TelefoneModelAssembler;
import com.avaliacao.surittec.api.model.TelefoneModel;
import com.avaliacao.surittec.api.model.input.TelefoneInput;
import com.avaliacao.surittec.domain.model.Telefone;
import com.avaliacao.surittec.domain.repository.TelefoneRepository;
import com.avaliacao.surittec.domain.service.CadastroTelefoneService;

@RestController
@RequestMapping(value = "/telefones")
public class TelefoneController {

	@Autowired
	private CadastroTelefoneService cadastroTelefoneService;
	
	@Autowired
	
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private TelefoneModelAssembler telefoneModelAssembler;
	
	@Autowired
	private TelefoneInputDisassembler telefoneInputDisassembler;
	
	@GetMapping
	public List<TelefoneModel> listar(){
		List<Telefone> todosTelefones = telefoneRepository.findAll();
		return telefoneModelAssembler.toCollectModel(todosTelefones);
	}
	
	@GetMapping("/{telefoneId}")
	public TelefoneModel buscar(@PathVariable Long telefoneId) {
		Telefone telefone = cadastroTelefoneService.buscarOuFalhar(telefoneId);
		
		return telefoneModelAssembler.toModel(telefone);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TelefoneModel adicionar(@Valid @RequestBody TelefoneInput telefoneInput) {
		Telefone telefone = telefoneInputDisassembler.toDomainObject(telefoneInput);
		
		return telefoneModelAssembler.toModel(cadastroTelefoneService.salvar(telefone));
	}
	
	@PutMapping("/{telefoneId}")
	public TelefoneModel atualizar(@Valid @RequestBody TelefoneInput telefoneInput, @PathVariable Long telefoneId) {
		Telefone telefoneAtual = cadastroTelefoneService.buscarOuFalhar(telefoneId);
		
		telefoneInputDisassembler.copyToDomainObject(telefoneAtual, telefoneInput);
		
		return telefoneModelAssembler.toModel(cadastroTelefoneService.salvar(telefoneAtual));
		
	}
	
	@DeleteMapping("/{telefoneId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long telefoneId) {
		cadastroTelefoneService.excluir(telefoneId);
	}
	
}
