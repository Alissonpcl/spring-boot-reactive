package br.com.alissonlima.sqssnsbackend.usuario.services.impl;

import br.com.alissonlima.sqssnsbackend.usuario.domains.Usuario;
import br.com.alissonlima.sqssnsbackend.usuario.entities.UsuarioEntity;
import br.com.alissonlima.sqssnsbackend.usuario.exceptions.UsuarioException;
import br.com.alissonlima.sqssnsbackend.usuario.exceptions.UsuarioInvalidoException;
import br.com.alissonlima.sqssnsbackend.usuario.mappers.UsuarioMapper;
import br.com.alissonlima.sqssnsbackend.usuario.repositories.UsuarioRepository;
import br.com.alissonlima.sqssnsbackend.usuario.services.api.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public Mono<Usuario> save(Usuario usuario) throws UsuarioException {
        log.debug("Iniciando save de usuario");

        if (StringUtils.isEmpty(usuario.getNome())){
            throw new UsuarioInvalidoException("Nome do usuario e obrigatorio");
        }
        if (StringUtils.isEmpty(usuario.getEmail())){
            throw new UsuarioInvalidoException("E-mail do usuario e obrigatorio");
        }
        if (StringUtils.isEmpty(usuario.getPassword())){
            throw new UsuarioInvalidoException("Password do usuario e obrigatorio");
        }

        UsuarioEntity pessoaEntity = usuarioMapper.toEntity(usuario);
        pessoaEntity.setDataHoraCriacao(LocalDateTime.now());

        Mono<UsuarioEntity> pessoaEntityMono = usuarioRepository.save(pessoaEntity);

        log.debug("Pessoa salva");
        return pessoaEntityMono.map(usuarioMapper::toDomain);
    }

    @Override
    public Flux<Usuario> listAll(Usuario pessoa) {
        log.debug("Listando todas as pessoas");
        return usuarioRepository
                .findAll()
                .map(usuarioMapper::toDomain);
    }
}
