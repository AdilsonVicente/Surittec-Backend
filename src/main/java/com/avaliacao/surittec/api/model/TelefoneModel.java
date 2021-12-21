package com.avaliacao.surittec.api.model;

import com.avaliacao.surittec.domain.model.TipoTelefone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefoneModel {

	private Long id;
    private ClienteModel cliente;
    private String numero;
    private TipoTelefone tipoTelefone;
}
