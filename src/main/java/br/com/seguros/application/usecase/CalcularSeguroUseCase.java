package br.com.seguros.application.usecase;

import br.com.seguros.domain.constants.CategoriaSeguroImpostos;
import br.com.seguros.domain.entity.Seguro;
import br.com.seguros.domain.exception.BadRequest;
import br.com.seguros.domain.repository.SeguroRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static br.com.seguros.domain.constants.CategoriaSeguroConstantes.*;

@Component
public class CalcularSeguroUseCase {

    private final SeguroRepository seguroRepository;

    public CalcularSeguroUseCase(SeguroRepository seguroRepository) {
        this.seguroRepository = seguroRepository;
    }

    public Seguro execute(String nome, String categoria, BigDecimal preco_base){

        if (categoria == null || categoria.isEmpty()){
            throw new BadRequest("Categoria não pode ser nula ou vazia");
        }

        switch (categoria.toUpperCase()) {
            case "VIDA" -> {
                return criarSeguro(nome, VIDA, preco_base);
            }
            case "AUTO" -> {
                return criarSeguro(nome, AUTO, preco_base);
            }
            case "VIAGEM" -> {
                return criarSeguro(nome, VIAGEM, preco_base);
            }
            case "RESIDENCIAL" -> {
                return criarSeguro(nome, RESIDENCIAL, preco_base);
            }
            case "PATRIMONIAL" -> {
                return criarSeguro(nome, PATRIMONIAL, preco_base);
            }
            default -> throw new BadRequest("Categoria Inválida: " + categoria);
        }

    }

    private Seguro criarSeguro(String nome, CategoriaSeguroImpostos categoria, BigDecimal preco_base){
        Seguro seguro = new Seguro();
        if (nome == null || nome.isEmpty()){
            throw new BadRequest("Nome não pode ser nulo ou vazio");
        }
        seguro.setNome(nome);
        seguro.setCategoria(categoria.nome());
        seguro.setPreco_base(preco_base);
        seguro.setPreco_tarifado(calcularImpostos(preco_base, categoria));

        return seguroRepository.save(seguro);
    }


    private BigDecimal calcularImpostos(BigDecimal preco_base, CategoriaSeguroImpostos categoria){

        if (preco_base == null || preco_base.equals(BigDecimal.ZERO) || preco_base.compareTo(BigDecimal.ZERO) < 0){
            throw new BadRequest("Preço base não pode ser nulo/menor ou igual a zero");
        }

        return preco_base.add((preco_base.multiply(categoria.iof())))
                .add(preco_base.multiply((categoria.pis())))
                .add(preco_base.multiply(categoria.cofins()));
    }


}
