package br.com.seguros.infrastructure.controller;

import br.com.seguros.application.service.ISeguroService;
import br.com.seguros.domain.entity.dto.SeguroDTO;
import br.com.seguros.infrastructure.controller.request.SeguroRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seguro")
public class SeguroController {

    private final ISeguroService seguroService;

    public SeguroController(ISeguroService seguroService) {
        this.seguroService = seguroService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<SeguroDTO> calcularSeguro(@RequestBody SeguroRequest request){
        SeguroDTO seguroDTO = seguroService.calcularSeguro(request.getNome(), request.getCategoria(), request.getPreco_base());
        return ResponseEntity.ok().body(seguroDTO);
    }

}
