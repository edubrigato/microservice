package br.com.seguros.application.factory;

import br.com.seguros.application.exception.BadRequest;
import br.com.seguros.domain.constants.CategoriaSeguroImpostos;
import br.com.seguros.domain.model.Seguro;

import java.math.BigDecimal;

public class SeguroFactory {

    public static Seguro criarSeguro(String nome, CategoriaSeguroImpostos categoria, BigDecimal preco_base) {
        if (nome == null || nome.isEmpty()) {
            throw new BadRequest("Nome não pode ser nulo ou vazio");
        }

        Seguro seguro = new Seguro();
        seguro.setNome(nome);
        seguro.setCategoria(categoria.nome());
        seguro.setPreco_base(preco_base);
        seguro.setPreco_tarifado(calcularImpostos(preco_base, categoria));

        return seguro;
    }

    private static BigDecimal calcularImpostos(BigDecimal preco_base, CategoriaSeguroImpostos categoria) {
        if (preco_base == null || preco_base.equals(BigDecimal.ZERO) || preco_base.compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequest("Preço base não pode ser nulo/menor ou igual a zero");
        }

        return preco_base.add(preco_base.multiply(categoria.iof()))
                .add(preco_base.multiply(categoria.pis()))
                .add(preco_base.multiply(categoria.cofins()));
    }
}

