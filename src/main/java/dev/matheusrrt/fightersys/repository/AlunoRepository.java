package dev.matheusrrt.fightersys.repository;

import dev.matheusrrt.fightersys.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlunoRepository extends JpaRepository<Aluno, Long>, JpaSpecificationExecutor<Aluno> {

     boolean existsByEmail(String email);



}
