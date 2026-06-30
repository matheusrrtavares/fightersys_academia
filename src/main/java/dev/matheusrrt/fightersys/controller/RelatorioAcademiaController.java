package dev.matheusrrt.fightersys.controller;

import dev.matheusrrt.fightersys.projection.AlunosPorCidadeProjection;
import dev.matheusrrt.fightersys.projection.FaturamentoMensalProjection;
import dev.matheusrrt.fightersys.projection.FaturasEmAbertoProjection;
import dev.matheusrrt.fightersys.repository.RelatorioAcademiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/relatorios")
@RequiredArgsConstructor
public class RelatorioAcademiaController {

    private final RelatorioAcademiaRepository relatorioAcademiaRepository;

    @GetMapping("/faturamento_mensal")
    public List<FaturamentoMensalProjection> faturamentoMensal(){
        return relatorioAcademiaRepository.faturamentoMensal();
    }

    @GetMapping("/alunos_por_cidade")
    public List<AlunosPorCidadeProjection> alunosPorCidade(){
        return relatorioAcademiaRepository.alunosPorCidade();
    }

    @GetMapping("/faturas_em_aberto")
    public List<FaturasEmAbertoProjection> faturasEmAberto(){
        return relatorioAcademiaRepository.faturasEmAberto();
    }

}
