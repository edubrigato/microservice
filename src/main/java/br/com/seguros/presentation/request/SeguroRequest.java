package br.com.seguros.presentation.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SeguroRequest {

    private String nome;
    private String categoria;
    private BigDecimal preco_base;

}
