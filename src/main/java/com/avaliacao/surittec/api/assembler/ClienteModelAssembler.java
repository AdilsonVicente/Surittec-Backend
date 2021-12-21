package com.avaliacao.surittec.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avaliacao.surittec.api.model.ClienteModel;
import com.avaliacao.surittec.domain.model.Cliente;

@Component
public class ClienteModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public ClienteModel toModel(Cliente cliente) {
		return modelMapper.map(cliente, ClienteModel.class);
	}
	
	public List<ClienteModel> toCollectModel(Collection<Cliente> clientes){
		return clientes.stream()
				.map(cliente -> toModel(cliente))
				.collect(Collectors.toList());
	}
}
