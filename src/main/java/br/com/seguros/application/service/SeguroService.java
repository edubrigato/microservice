package br.com.seguros.application.service;

import br.com.seguros.application.dto.SeguroDTO;

import java.math.BigDecimal;

public interface SeguroService {

    SeguroDTO calcularSeguro(String nome, String categoriaStr, BigDecimal preco_base);

}
