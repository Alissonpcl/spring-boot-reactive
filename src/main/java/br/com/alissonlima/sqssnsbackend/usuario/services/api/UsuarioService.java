package br.com.alissonlima.sqssnsbackend.usuario.services.api;

import br.com.alissonlima.sqssnsbackend.usuario.domains.Usuario;
import br.com.alissonlima.sqssnsbackend.usuario.exceptions.UsuarioException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioService {
    Mono<Usuario> save(Usuario pessoa) throws UsuarioException;

    Flux<Usuario> listAll(Usuario pessoa) throws UsuarioException;
}
