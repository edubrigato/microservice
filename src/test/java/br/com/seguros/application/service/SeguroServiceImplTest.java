package br.com.seguros.application.service;

import br.com.seguros.application.dto.SeguroDTO;
import br.com.seguros.application.exception.BadRequest;
import br.com.seguros.application.mapper.SeguroMapper;
import br.com.seguros.domain.model.Seguro;
import br.com.seguros.domain.repository.SeguroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class SeguroServiceImplTest {

    @InjectMocks
    private SeguroServiceImpl seguroService;

    @Mock
    private SeguroRepository seguroRepository;

    @Mock
    private SeguroMapper seguroMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalcularSeguro() {
        String nome = "Teste";
        String categoriaStr = "VIDA";
        BigDecimal precoBase = BigDecimal.valueOf(1000.00);

        Seguro seguro = new Seguro();

        SeguroDTO seguroDTO = new SeguroDTO();

        when(seguroRepository.save(seguro)).thenReturn(seguro);
        when(seguroMapper.toDTO(seguro)).thenReturn(seguroDTO);

        SeguroDTO result = seguroService.calcularSeguro(nome, categoriaStr, precoBase);

        assertNotNull(result, "O resultado não deve ser nulo");
    }

    @Test
    void testCalcularSeguroCategoriaNula() {
        String nome = "Teste";
        String categoriaStr = null;
        BigDecimal precoBase = BigDecimal.valueOf(1000.00);

        BadRequest thrown = assertThrows(BadRequest.class, () -> seguroService.calcularSeguro(nome, categoriaStr, precoBase));
        assertEquals("Categoria não pode ser nula ou vazia", thrown.getMessage());
    }

    @Test
    void testCalcularSeguroCategoriaVazia() {
        String nome = "Teste";
        String categoriaStr = "";
        BigDecimal precoBase = BigDecimal.valueOf(1000.00);

        BadRequest thrown = assertThrows(BadRequest.class, () -> seguroService.calcularSeguro(nome, categoriaStr, precoBase));
        assertEquals("Categoria não pode ser nula ou vazia", thrown.getMessage());
    }
}