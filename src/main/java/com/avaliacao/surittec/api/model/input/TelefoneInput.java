package com.avaliacao.surittec.api.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.avaliacao.surittec.domain.model.TipoTelefone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefoneInput {

    private ClienteInput cliente;

    @NotBlank(message = "Numero é requerido")
    private String numero;

    @NotNull(message = "Tipo de telefone é requerido")
    private TipoTelefone tipoTelefone;
}
