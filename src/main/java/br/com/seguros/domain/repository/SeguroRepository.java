package br.com.seguros.domain.repository;

import br.com.seguros.domain.model.Seguro;

public interface SeguroRepository {

    Seguro save(Seguro seguro);
}
