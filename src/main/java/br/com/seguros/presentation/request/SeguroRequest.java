package br.com.seguros.presentation.request;

import java.math.BigDecimal;

public class SeguroRequest {

    private String nome;
    private String categoria;
    private BigDecimal preco_base;

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco_base() {
        return preco_base;
    }
}
