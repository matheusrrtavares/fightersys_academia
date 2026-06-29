package dev.matheusrrt.fightersys.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.matheusrrt.fightersys.domain.Aluno;

import java.time.LocalDate;

public record AlunoRequest(
        String nome,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,
        String sexo,
        String telefone,
        String celular,
        String email,
        String observacao,
        String endereco,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String cep
) {

    public Aluno toEntity(){
        Aluno aluno = new Aluno();
        preencher(aluno);
        return aluno;
    }

    public void preencher(Aluno aluno){
        aluno.setNome(nome);
        aluno.setDataNascimento(dataNascimento);
        aluno.setSexo(sexo);
        aluno.setTelefone(telefone);
        aluno.setCelular(celular);
        aluno.setEmail(email);
        aluno.setObservacao(observacao);
        aluno.setEndereco(endereco);
        aluno.setNumero(numero);
        aluno.setComplemento(complemento);
        aluno.setBairro(bairro);
        aluno.setCidade(cidade);
        aluno.setCep(cep);

    }

}
