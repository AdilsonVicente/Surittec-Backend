package com.avaliacao.surittec.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avaliacao.surittec.api.model.input.UsuarioComSenhaInput;
import com.avaliacao.surittec.api.model.input.UsuarioInput;
import com.avaliacao.surittec.domain.model.Usuario;

@Component
public class UsuarioInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Usuario toDomainObject(UsuarioComSenhaInput usuarioComSenhaInput) {
		return modelMapper.map(usuarioComSenhaInput, Usuario.class);
	}
	
	public void copyToDomainObject(UsuarioInput usuarioInput, Usuario usuario) {
		modelMapper.map(usuarioInput, usuario);
	}
}
