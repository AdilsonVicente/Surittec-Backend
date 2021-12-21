package com.avaliacao.surittec.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avaliacao.surittec.api.model.input.ClienteInput;
import com.avaliacao.surittec.domain.model.Cliente;

@Component
public class ClienteInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Cliente toDomainObject(ClienteInput clienteInput) {
		return modelMapper.map(clienteInput, Cliente.class);
	}
	
	public void copyToDomainObject(Cliente cliente, ClienteInput clienteInput) {
		modelMapper.map(clienteInput, cliente);
	}
}
