package br.com.seguros.domain.repository;

import br.com.seguros.domain.entity.Seguro;

public interface SeguroRepository {

    Seguro save(Seguro seguro);
}
