package com.avaliacao.surittec.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Telefone {

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Numero é requerido")
    private String numero;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Tipo de telefone é requerido")
    private TipoTelefone tipoTelefone;
}
