package br.com.seguros.application.factory;

import br.com.seguros.domain.constants.CategoriaSeguroImpostos;
import br.com.seguros.domain.model.Seguro;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class SeguroFactoryTest {

    @InjectMocks
    private SeguroFactory seguroFactory;

    @Test
    public void testCriarSeguroComDadosValidos() {
        CategoriaSeguroImpostos categoria = new CategoriaSeguroImpostos("VIDA", new BigDecimal("0.1"), new BigDecimal("0.05"), new BigDecimal("0.02"));
        Seguro seguro = SeguroFactory.criarSeguro("Seguro Vida", categoria, new BigDecimal("1000.00"));

        assertNotNull(seguro);
        assertEquals("Seguro Vida", seguro.getNome());
        assertEquals("VIDA", seguro.getCategoria());
        assertEquals(new BigDecimal("1000.00"), seguro.getPreco_base());
        assertEquals(new BigDecimal("1170.00"), seguro.getPreco_tarifado());
    }

}