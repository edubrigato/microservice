package br.com.seguros.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Seguro {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String nome;

    private String categoria;

    private BigDecimal preco_base;

    private BigDecimal preco_tarifado;

    public UUID getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
