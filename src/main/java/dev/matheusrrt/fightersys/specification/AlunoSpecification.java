package dev.matheusrrt.fightersys.specification;

import dev.matheusrrt.fightersys.domain.Aluno;
import dev.matheusrrt.fightersys.dto.AlunoFiltroRequest;
import dev.matheusrrt.fightersys.dto.AlunoRequest;
import org.springframework.data.jpa.domain.Specification;

public class AlunoSpecification {

    public static Specification<Aluno> comFiltros(AlunoFiltroRequest filtro){
        return Specification
                .where(nomeContem(filtro.nome()))
                .and(emailContem(filtro.email()))
                .and(celularContem(filtro.celular()))
                .and(cidadeContem(filtro.cidade()))
                .and(estadoIgual(filtro.estado()));
    }

    public static Specification<Aluno> nomeContem(String nome){
        return (root, query, criteriaBuilder) -> {
            if(nome == null || nome.isBlank()){
                return null;
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
        };
    }

    public static Specification<Aluno> emailContem(String email){
        return (root, query, cb) -> {
            if(email == null || email.isBlank()){
                return null;
            }
          return cb.like(cb.lower(root.get("email")), "%" + email.toLowerCase() + "%");
        };
    }

    public static Specification<Aluno> celularContem(String celular){
        return (root, query, cb) -> {
            if(celular == null || celular.isBlank()){
                return null;
            }
            return cb.like(cb.lower(root.get("celular")), "%" + celular.toLowerCase() + "%");
        };
    }

    public static Specification<Aluno> cidadeContem(String cidade){
        return (root, query, cb) -> {
            if(cidade == null || cidade.isBlank()){
                return null;
            }
            return cb.like(cb.lower(root.get("cidade")), "%" + cidade.toLowerCase() + "%");
        };
    }

    public static Specification<Aluno> estadoIgual(String estado){
        return (root, query, cb) -> {
            if(estado == null || estado.isBlank()){
                return null;
            }
            return cb.equal(cb.upper(root.get("estado")), estado.toUpperCase());
        };
    }

}
