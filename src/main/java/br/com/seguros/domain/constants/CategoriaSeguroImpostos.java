package br.com.seguros.domain.constants;

import br.com.seguros.application.exception.BadRequest;

import java.math.BigDecimal;

public record CategoriaSeguroImpostos(String nome, BigDecimal iof, BigDecimal pis, BigDecimal cofins) {

    public static CategoriaSeguroImpostos fromString(String categoria) {
        return switch (categoria.toUpperCase()) {
            case "VIDA" -> new CategoriaSeguroImpostos("VIDA", new BigDecimal("0.01"), new BigDecimal("0.02"), new BigDecimal("0.0"));
            case "AUTO" -> new CategoriaSeguroImpostos("AUTO", new BigDecimal("0.055"), new BigDecimal("0.04"), new BigDecimal("0.01"));
            case "VIAGEM" -> new CategoriaSeguroImpostos("VIAGEM", new BigDecimal("0.02"), new BigDecimal("0.04"), new BigDecimal("0.01"));
            case "RESIDENCIAL" -> new CategoriaSeguroImpostos("RESIDENCIAL", new BigDecimal("0.04"), new BigDecimal("0.0"), new BigDecimal("0.03"));
            case "PATRIMONIAL" -> new CategoriaSeguroImpostos("PATRIMONIAL", new BigDecimal("0.05"), new BigDecimal("0.03"), new BigDecimal("0.0"));
            default -> throw new BadRequest("Categoria Inválida: " + categoria);
        };
    }


}
