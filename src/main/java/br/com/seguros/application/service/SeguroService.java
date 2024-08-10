package br.com.seguros.application.service;

import br.com.seguros.domain.model.Seguro;

import java.math.BigDecimal;

public interface SeguroService {

    Seguro calcularSeguro(String nome, String categoriaStr, BigDecimal preco_base);

}
