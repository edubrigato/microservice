package br.com.seguros.infrastructure.repository;

import br.com.seguros.domain.entity.Seguro;
import br.com.seguros.domain.repository.SeguroRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SeguroRepositoryImpl extends JpaRepository<Seguro, UUID>, SeguroRepository {
}
