package br.com.seguros.domain.constants;

import java.math.BigDecimal;

public class CategoriaSeguroConstantes {

    public static final CategoriaSeguroImpostos VIDA = new CategoriaSeguroImpostos(
            "VIDA", new BigDecimal("0.01"), new BigDecimal("0.02"), new BigDecimal("0.0"));
    public static final CategoriaSeguroImpostos AUTO = new CategoriaSeguroImpostos(
            "AUTO", new BigDecimal("0.055"), new BigDecimal("0.04"), new BigDecimal("0.01"));
    public static final CategoriaSeguroImpostos VIAGEM = new CategoriaSeguroImpostos(
            "VIAGEM", new BigDecimal("0.02"), new BigDecimal("0.04"), new BigDecimal("0.01"));
    public static final CategoriaSeguroImpostos RESIDENCIAL = new CategoriaSeguroImpostos(
            "RESIDENCIAL", new BigDecimal("0.04"), new BigDecimal("0.0"), new BigDecimal("0.03"));
    public static final CategoriaSeguroImpostos PATRIMONIAL = new CategoriaSeguroImpostos(
            "PATRIMONIAL", new BigDecimal("0.05"), new BigDecimal("0.03"), new BigDecimal("0.0"));


}
