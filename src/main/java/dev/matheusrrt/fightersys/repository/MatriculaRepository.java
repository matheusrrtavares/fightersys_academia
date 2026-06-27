package dev.matheusrrt.fightersys.repository;

import dev.matheusrrt.fightersys.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
