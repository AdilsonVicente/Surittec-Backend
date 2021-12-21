package com.avaliacao.surittec.api.model.input;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.avaliacao.surittec.api.model.EnderecoModel;
import com.avaliacao.surittec.domain.model.Email;
import com.avaliacao.surittec.domain.model.Telefone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteInput {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100)
	private String nome;
	
    @NotBlank(message = "CPF é obrigatório")
	private String cpf;
    
	@NotNull(message = "Endereço é obrigatório")
	private EnderecoModel endereco;
	
	 @Size(min = 1, message = "Ao menos um telefone é obrigatório")
	 private Set<Telefone> telefones;
	 
	 @Size(min = 1, message = "Ao menos um email é obrigatório")
	 private Set<Email> emails;
}
