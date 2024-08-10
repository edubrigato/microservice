package br.com.seguros.application.factory;

import br.com.seguros.application.exception.BadRequest;
import br.com.seguros.domain.constants.CategoriaSeguroImpostos;
import br.com.seguros.domain.model.Seguro;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SeguroFactoryTest {

    @Test
    void testCriarSeguro() {
        String nome = "Teste";
        CategoriaSeguroImpostos categoria = new CategoriaSeguroImpostos("VIDA", BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.02), BigDecimal.valueOf(0.03));
        BigDecimal precoBase = BigDecimal.valueOf(1000.00);

        Seguro seguro = SeguroFactory.criarSeguro(nome, categoria, precoBase);

        assertNotNull(seguro, "Seguro não deve ser nulo");
        assertEquals(nome, seguro.getNome(), "Nome do seguro não corresponde");
        assertEquals(categoria.nome(), seguro.getCategoria(), "Categoria do seguro não corresponde");
        assertEquals(precoBase, seguro.getPreco_base(), "Preço base do seguro não corresponde");
        assertEquals(precoBase.add(precoBase.multiply(categoria.iof()))
                        .add(precoBase.multiply(categoria.pis()))
                        .add(precoBase.multiply(categoria.cofins())),
                seguro.getPreco_tarifado(), "Preço tarifado calculado incorretamente");
    }

    @Test
    void testCriarSeguroNomeNulo() {
        CategoriaSeguroImpostos categoria = new CategoriaSeguroImpostos("VIDA", BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.02), BigDecimal.valueOf(0.03));
        BigDecimal precoBase = BigDecimal.valueOf(1000.00);

        assertThrows(BadRequest.class, () -> SeguroFactory.criarSeguro(null, categoria, precoBase), "Nome não pode ser nulo");
    }

    @Test
    void testCriarSeguroNomeVazio() {
        CategoriaSeguroImpostos categoria = new CategoriaSeguroImpostos("VIDA", BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.02), BigDecimal.valueOf(0.03));
        BigDecimal precoBase = BigDecimal.valueOf(0);

        assertThrows(BadRequest.class, () -> SeguroFactory.criarSeguro("", categoria, precoBase), "Nome não pode ser nulo");
    }

    @Test
    void testCriarSeguroPrecoBaseIgualA0() {
        CategoriaSeguroImpostos categoria = new CategoriaSeguroImpostos("VIDA", BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.02), BigDecimal.valueOf(0.03));
        BigDecimal precoBase = BigDecimal.valueOf(0);

        assertThrows(BadRequest.class, () -> SeguroFactory.criarSeguro("Teste", categoria, precoBase), "Preço base não pode ser nulo/menor ou igual a zero");
    }

    @Test
    void testCriarSeguroPrecoBaseMenor0() {
        CategoriaSeguroImpostos categoria = new CategoriaSeguroImpostos("VIDA", BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.02), BigDecimal.valueOf(0.03));
        BigDecimal precoBase = BigDecimal.valueOf(-1000.00);

        assertThrows(BadRequest.class, () -> SeguroFactory.criarSeguro("Teste", categoria, precoBase), "Preço base não pode ser nulo/menor ou igual a zero");
    }

    @Test
    void testCriarSeguroPrecoBaseNull() {
        CategoriaSeguroImpostos categoria = new CategoriaSeguroImpostos("VIDA", BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.02), BigDecimal.valueOf(0.03));

        assertThrows(BadRequest.class, () -> SeguroFactory.criarSeguro("Teste", categoria, null), "Preço base não pode ser nulo/menor ou igual a zero");
    }

}