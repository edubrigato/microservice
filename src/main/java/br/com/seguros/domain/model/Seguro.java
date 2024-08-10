package br.com.seguros.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
public class Seguro {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String nome;

    private String categoria;

    private BigDecimal preco_base;

    private BigDecimal preco_tarifado;

}
