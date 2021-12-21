package com.avaliacao.surittec.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avaliacao.surittec.api.model.TelefoneModel;
import com.avaliacao.surittec.domain.model.Telefone;

@Component
public class TelefoneModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public TelefoneModel toModel(Telefone telefone) {
		return modelMapper.map(telefone, TelefoneModel.class);
	}
	
	public List<TelefoneModel> toCollectModel(Collection<Telefone> telefones){
		return telefones.stream()
				.map(telefone -> toModel(telefone))
				.collect(Collectors.toList());
	}
}
