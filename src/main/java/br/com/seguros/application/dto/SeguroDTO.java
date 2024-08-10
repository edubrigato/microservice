package br.com.seguros.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class SeguroDTO {

    private UUID id;

    private String nome;

    private String categoria;

    private BigDecimal preco_base;

    private BigDecimal preco_tarifado;


}
