package br.com.alissonlima.sqssnsbackend.usuario.mappers;

import br.com.alissonlima.sqssnsbackend.usuario.domains.Usuario;
import br.com.alissonlima.sqssnsbackend.usuario.dtos.NovoUsuarioDto;
import br.com.alissonlima.sqssnsbackend.usuario.entities.UsuarioEntity;
import org.mapstruct.*;

/*
Esta classe aplica o Pattern Adapter fazendo a conversão da entidade
para o domínio com o objetivo de isolar as responsabilidades, onde a
entidade tem a responsabilidade de mapear as regras de persistência (DB)
enquanto que o domínio atende as regras de negócio do produto (aplicação).

Em um aplicação simples como esta o benefício desta conversão pode não
ficar claro no início do projeto, porém conforme o projeto cresce é normal
que responsabilidades específicas aparecem em cada uma dessas classes.

Por exemplo, pode ser necessário adicionar uma função na classe de domínio
que calcula a idade de uma Pessoa, enquanto que na classe de entidade pode ser
necessário adicionar novas anotações para mapear as tipos de dados do banco
(ex @CreationTimestamp), etc.
* */

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = {})
public interface NovoUsuarioMapper {

    @Mappings({})
    Usuario toDomain(NovoUsuarioDto dto);

    @Mappings({})
    NovoUsuarioDto toDto(Usuario domain);
}
