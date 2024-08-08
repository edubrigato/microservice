package br.com.seguros.application.service;

import br.com.seguros.domain.entity.dto.SeguroDTO;

import java.math.BigDecimal;

public interface ISeguroService {

    SeguroDTO calcularSeguro(String nome, String categoria, BigDecimal preco_base);

}
