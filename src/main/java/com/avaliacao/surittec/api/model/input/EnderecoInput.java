package com.avaliacao.surittec.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoInput {

	@NotBlank(message = "CEP é obrigatório")
	private String cep;
	
	@NotBlank(message = "Logradouro é obrigatório")
	private String logradouro;
	
	@NotBlank(message = "Bairro é obrigatório")
	private String bairro;
	
	@NotBlank(message = "Cidade é obrigatório")
	private String cidade;
	
	@NotBlank(message = "UF é obrigatória")
	private String uf;
	
	private String complemento;

}
