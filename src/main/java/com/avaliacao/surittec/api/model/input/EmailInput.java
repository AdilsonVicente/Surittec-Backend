package com.avaliacao.surittec.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailInput {

	@NotBlank(message = "Email é obrigatório")
	private String emailAddress;
}
