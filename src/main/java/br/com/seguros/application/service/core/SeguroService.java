package br.com.seguros.application.service.core;

import br.com.seguros.application.service.ISeguroService;
import br.com.seguros.application.usecase.CalcularSeguroUseCase;
import br.com.seguros.domain.entity.dto.SeguroDTO;
import br.com.seguros.mapper.SeguroMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SeguroService implements ISeguroService {

    private final CalcularSeguroUseCase calcularSeguroUseCase;

    public SeguroService(CalcularSeguroUseCase calcularSeguroUseCase) {
        this.calcularSeguroUseCase = calcularSeguroUseCase;
    }


    @Override
    public SeguroDTO calcularSeguro(String nome, String categoria, BigDecimal preco_base) {

        return SeguroMapper.INSTANCE.toDTO(calcularSeguroUseCase.execute(nome, categoria, preco_base));
    }
}
