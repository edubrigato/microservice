package br.com.seguros.presentation;

import br.com.seguros.application.dto.SeguroDTO;
import br.com.seguros.application.exception.BadRequest;
import br.com.seguros.application.service.SeguroService;
import br.com.seguros.presentation.request.SeguroRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class SeguroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SeguroService seguroService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalcularSeguro() throws Exception {
        SeguroDTO seguroDTO = new SeguroDTO();
        seguroDTO.setNome("Seguro Vida");
        seguroDTO.setPreco_base(BigDecimal.valueOf(1000.00));
        seguroDTO.setPreco_tarifado(BigDecimal.valueOf(1200.00));

        when(seguroService.calcularSeguro(any(String.class), any(String.class), any(BigDecimal.class)))
                .thenReturn(seguroDTO);

        SeguroRequest request = new SeguroRequest();
        request.setNome("Seguro Vida");
        request.setCategoria("VIDA");
        request.setPreco_base(BigDecimal.valueOf(1000.00));

        mockMvc.perform(post("/api/seguro/calcular")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Seguro Vida"))
                .andExpect(jsonPath("$.preco_base").value(1000.00))
                .andExpect(jsonPath("$.preco_tarifado").value(1200.00));
    }

    @Test
    void testCalcularSeguroBadRequest() throws Exception {
        when(seguroService.calcularSeguro(any(String.class), any(String.class), any(BigDecimal.class)))
                .thenThrow(new BadRequest("Categoria não pode ser nula ou vazia"));

        SeguroRequest request = new SeguroRequest();
        request.setNome("Seguro Vida");
        request.setCategoria("");
        request.setPreco_base(BigDecimal.valueOf(1000.00));

        mockMvc.perform(post("/api/seguro/calcular")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

}
