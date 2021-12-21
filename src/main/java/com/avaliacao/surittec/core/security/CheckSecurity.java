package com.avaliacao.surittec.core.security;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public @interface CheckSecurity {

	public @interface Clientes {
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('ADMINISTRADOR')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface Admin {}

		@PreAuthorize("hasAuthority('SCOPE_READ') and isAuthenticated")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface Consultar {}
	}
}
