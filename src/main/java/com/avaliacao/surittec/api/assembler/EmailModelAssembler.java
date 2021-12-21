package com.avaliacao.surittec.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avaliacao.surittec.api.model.EmailModel;
import com.avaliacao.surittec.domain.model.Email;

@Component
public class EmailModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public EmailModel toModel(Email email) {
		return modelMapper.map(email, EmailModel.class);
	}
	
	public List<EmailModel> toCollectModel(Collection<Email> emails){
		return emails.stream()
				.map(email -> toModel(email))
				.collect(Collectors.toList());
	}
}
