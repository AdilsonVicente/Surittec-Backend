package com.avaliacao.surittec.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avaliacao.surittec.api.model.input.EmailInput;
import com.avaliacao.surittec.domain.model.Email;

@Component
public class EmailInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Email toDomainObject(EmailInput emailInput) {
		return modelMapper.map(emailInput, Email.class);
	}
	
	public void copyToDomainObject(Email email, EmailInput emailInput) {
		modelMapper.map(emailInput, email);
	}
}
