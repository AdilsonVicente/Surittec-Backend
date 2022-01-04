package com.avaliacao.surittec.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.surittec.api.assembler.ClienteInputDisassembler;
import com.avaliacao.surittec.api.assembler.ClienteModelAssembler;
import com.avaliacao.surittec.api.model.ClienteModel;
import com.avaliacao.surittec.api.model.input.ClienteInput;
import com.avaliacao.surittec.core.security.CheckSecurity;
import com.avaliacao.surittec.domain.model.Cliente;
import com.avaliacao.surittec.domain.repository.ClienteRepository;
import com.avaliacao.surittec.domain.service.CadastroClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private CadastroClienteService cadastroClienteService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteModelAssembler clienteModelAssembler;
	
	@Autowired
	private ClienteInputDisassembler clienteInputDisassembler;
	
	@CheckSecurity.Clientes.Consultar
	@GetMapping
	public List<ClienteModel> listar(){
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		List<Cliente> todosClientes = clienteRepository.findAll();
		return clienteModelAssembler.toCollectModel(todosClientes);
	}
	
	@CheckSecurity.Clientes.Consultar
	@GetMapping("/{ClienteId}")
	public ClienteModel buscar(@PathVariable Long clienteId) {
		Cliente Cliente = cadastroClienteService.buscarOuFalhar(clienteId);
		
		return clienteModelAssembler.toModel(Cliente);
	}
	
	@CheckSecurity.Clientes.Admin
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteModel adicionar(@Valid @RequestBody ClienteInput clienteInput) {
		Cliente cliente = clienteInputDisassembler.toDomainObject(clienteInput);
		
		return clienteModelAssembler.toModel(cadastroClienteService.salvar(cliente));
	}
	
	@CheckSecurity.Clientes.Admin
	@PutMapping("/{clienteId}")
	public ClienteModel atualizar(@Valid @RequestBody ClienteInput clienteInput, @PathVariable Long clienteId) {
		Cliente clienteAtual = cadastroClienteService.buscarOuFalhar(clienteId);
		
		clienteInputDisassembler.copyToDomainObject(clienteAtual, clienteInput);
		
		return clienteModelAssembler.toModel(cadastroClienteService.salvar(clienteAtual));
		
	}
	
	@CheckSecurity.Clientes.Admin
	@DeleteMapping("/{clienteId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long clienteId) {
		cadastroClienteService.excluir(clienteId);
	}
	
}
