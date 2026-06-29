package dev.matheusrrt.fightersys.repository;

import dev.matheusrrt.fightersys.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

     boolean existsByEmail(String email);



}
