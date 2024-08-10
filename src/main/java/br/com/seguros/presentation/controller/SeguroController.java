package br.com.seguros.presentation.controller;

import br.com.seguros.application.dto.SeguroDTO;
import br.com.seguros.application.service.SeguroService;
import br.com.seguros.domain.model.Seguro;
import br.com.seguros.presentation.mapper.SeguroMapper;
import br.com.seguros.presentation.request.SeguroRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seguro")
public class SeguroController {

    private final SeguroService seguroService;

    public SeguroController(SeguroService seguroService) {
        this.seguroService = seguroService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<SeguroDTO> calcularSeguro(@RequestBody SeguroRequest request) {
        Seguro seguro = seguroService.calcularSeguro(request.getNome(), request.getCategoria(), request.getPreco_base());
        return ResponseEntity.ok().body(SeguroMapper.INSTANCE.toDTO(seguro));
    }

}
