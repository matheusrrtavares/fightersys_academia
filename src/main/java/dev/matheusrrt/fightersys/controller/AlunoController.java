package dev.matheusrrt.fightersys.controller;

import dev.matheusrrt.fightersys.dto.AlunoFiltroRequest;
import dev.matheusrrt.fightersys.dto.AlunoRequest;
import dev.matheusrrt.fightersys.dto.AlunoResponse;
import dev.matheusrrt.fightersys.service.AlunoService;
import dev.matheusrrt.fightersys.specification.AlunoSpecification;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
@Slf4j
public class AlunoController {

    private final AlunoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoResponse cadastrar(@RequestBody @Valid AlunoRequest request){
        return service.cadastrar(request);
    }

    @GetMapping
    public Page<AlunoResponse> listar(AlunoFiltroRequest filtro, Pageable pageable){
        return service.listar(filtro, pageable);
    }

    @GetMapping("/{id}")
    public AlunoResponse buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AlunoResponse atualizar(@PathVariable Long id, @RequestBody @Valid AlunoRequest request){
        return service.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
         service.excluir(id);
    }

}
