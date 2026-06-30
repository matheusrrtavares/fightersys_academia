package dev.matheusrrt.fightersys.service;

import dev.matheusrrt.fightersys.domain.Aluno;
import dev.matheusrrt.fightersys.dto.AlunoRequest;
import dev.matheusrrt.fightersys.dto.AlunoResponse;
import dev.matheusrrt.fightersys.exception.RegraNegocioException;
import dev.matheusrrt.fightersys.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoResponse cadastrar(AlunoRequest request){
        if(request.email() != null && alunoRepository.existsByEmail(request.email())){
            throw new RegraNegocioException("Já existe um aluno cadastrado com esse email!");
        }

        Aluno aluno = request.toEntity();
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoSalvo);
    }

    public Page<AlunoResponse> listar(Pageable pageable){
        return alunoRepository.findAll(pageable).map(AlunoResponse::fromEntity);
    }

    public AlunoResponse buscarPorId(Long id){
        Aluno aluno = buscarEntidadePorId(id);
        return AlunoResponse.fromEntity(aluno);
    }

    public AlunoResponse atualizar(Long id, AlunoRequest request){
        Aluno aluno = buscarEntidadePorId(id);
        request.preencher(aluno);
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoAtualizado);
    }

    public void excluir(Long id){
        Aluno aluno = buscarEntidadePorId(id);
        alunoRepository.delete(aluno);
    }

    private Aluno buscarEntidadePorId(Long id){
        return alunoRepository.findById(id).orElseThrow(
                () -> new RegraNegocioException("Aluno não encontrado"));
    }

}
