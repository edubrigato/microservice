package br.com.seguros.domain.entity.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class SeguroDTO {

    private UUID id;

    private String nome;

    private String categoria;

    private BigDecimal preco_base;

    private BigDecimal preco_tarifado;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco_base() {
        return preco_base;
    }

    public void setPreco_base(BigDecimal preco_base) {
        this.preco_base = preco_base;
    }

    public BigDecimal getPreco_tarifado() {
        return preco_tarifado;
    }

    public void setPreco_tarifado(BigDecimal preco_tarifado) {
        this.preco_tarifado = preco_tarifado;
    }
}
