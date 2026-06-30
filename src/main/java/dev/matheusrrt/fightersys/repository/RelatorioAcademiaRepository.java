package dev.matheusrrt.fightersys.repository;

import dev.matheusrrt.fightersys.domain.FaturaMatricula;
import dev.matheusrrt.fightersys.projection.AlunosPorCidadeProjection;
import dev.matheusrrt.fightersys.projection.FaturamentoMensalProjection;
import dev.matheusrrt.fightersys.projection.FaturasEmAbertoProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.*;

public interface RelatorioAcademiaRepository extends Repository<FaturaMatricula, Long> {

    @Query(
            value = """
                    SELECT
                        TO_CHAR(data_vencimento, 'YYYY-MM') AS mes,
                        SUM(valor) AS total
                    FROM faturas_matriculas
                    WHERE status = 'PAGA'
                    GROUP BY TO_CHAR(data_vencimento, 'YYYY-MM')
                    ORDER BY mes
                    """,
            nativeQuery = true
    )
    List<FaturamentoMensalProjection> faturamentoMensal();

    @Query(
            value = """
                    SELECT
                        cidade,
                        count(*) as quantidade
                    FROM alunos
                    GROUP BY cidade
                    ORDER BY quantidade desc
                    """,
            nativeQuery = true
    )
    List<AlunosPorCidadeProjection> alunosPorCidade();

    @Query(
            value = """
                    SELECT
                        m.id as matricula_id,
                        a.nome as alunoNome,
                        f.data_vencimento as dataVencimento
                    FROM faturas_matriculas f
                    JOIN matriculas m ON m.id = f.matricula_id
                    JOIN alunos a ON a.id = m.aluno_id
                    WHERE f.status = 'ABERTA'
                    ORDER BY f.data_vencimento desc
                    """,
            nativeQuery = true
    )
    List<FaturasEmAbertoProjection> faturasEmAberto();

}
