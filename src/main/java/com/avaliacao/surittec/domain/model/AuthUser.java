package com.avaliacao.surittec.domain.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class AuthUser extends User{

	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String fullName;
	
	public AuthUser(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getNome(), usuario.getSenha(), Collections.emptyList());
		
		this.userId = usuario.getId();
		this.fullName = usuario.getNome();
	}

}
