package com.avaliacao.surittec.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avaliacao.surittec.api.model.input.GrupoInput;
import com.avaliacao.surittec.domain.model.Grupo;

@Component
public class GrupoInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Grupo toDomainObject(GrupoInput grupoInput) {
		return modelMapper.map(grupoInput, Grupo.class);
	}
	
	public void copyToDomainObject(Grupo grupo, GrupoInput grupoInput) {
		modelMapper.map(grupoInput, grupo);
	}
}
