package com.avaliacao.surittec.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailModel {

	private Long id;
    private ClienteModel cliente;
    private String emailAddress;
}
