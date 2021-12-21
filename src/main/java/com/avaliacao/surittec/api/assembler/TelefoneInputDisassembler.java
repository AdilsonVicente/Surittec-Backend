package com.avaliacao.surittec.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avaliacao.surittec.api.model.input.TelefoneInput;
import com.avaliacao.surittec.domain.model.Telefone;

@Component
public class TelefoneInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Telefone toDomainObject(TelefoneInput telefoneInput) {
		return modelMapper.map(telefoneInput, Telefone.class);
	}
	
	public void copyToDomainObject(Telefone telefone, TelefoneInput telefoneInput) {
		modelMapper.map(telefoneInput, telefone);
	}
}
