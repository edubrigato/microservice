package br.com.seguros.application.service;

import br.com.seguros.application.dto.SeguroDTO;
import br.com.seguros.application.mapper.SeguroMapper;
import br.com.seguros.domain.model.Seguro;
import br.com.seguros.application.exception.BadRequest;
import br.com.seguros.application.factory.SeguroFactory;
import br.com.seguros.domain.constants.CategoriaSeguroImpostos;
import br.com.seguros.domain.repository.SeguroRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SeguroServiceImpl implements SeguroService {


    private final SeguroRepository seguroRepository;

    public SeguroServiceImpl(SeguroRepository seguroRepository) {
        this.seguroRepository = seguroRepository;
    }

    public SeguroDTO calcularSeguro(String nome, String categoriaStr, BigDecimal preco_base) {
        if (categoriaStr == null || categoriaStr.isEmpty()) {
            throw new BadRequest("Categoria não pode ser nula ou vazia");
        }

        CategoriaSeguroImpostos categoria = CategoriaSeguroImpostos.fromString(categoriaStr.toUpperCase());

        Seguro seguro = SeguroFactory.criarSeguro(nome, categoria, preco_base);
        seguroRepository.save(seguro);
        return SeguroMapper.INSTANCE.toDTO(seguro);
    }
}
