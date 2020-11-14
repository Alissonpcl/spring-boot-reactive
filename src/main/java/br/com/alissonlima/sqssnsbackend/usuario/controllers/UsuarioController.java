package br.com.alissonlima.sqssnsbackend.usuario.controllers;

import br.com.alissonlima.sqssnsbackend.usuario.domains.Usuario;
import br.com.alissonlima.sqssnsbackend.usuario.dtos.NovoUsuarioDto;
import br.com.alissonlima.sqssnsbackend.usuario.exceptions.UsuarioException;
import br.com.alissonlima.sqssnsbackend.usuario.exceptions.UsuarioInvalidoException;
import br.com.alissonlima.sqssnsbackend.usuario.mappers.NovoUsuarioMapper;
import br.com.alissonlima.sqssnsbackend.usuario.services.api.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("pessoa")
public class UsuarioController {

    private final UsuarioService pessoaService;
    private final NovoUsuarioMapper novoUsuarioMapper;

    @PostMapping
    public ResponseEntity<Mono<Usuario>> salvar(@RequestBody NovoUsuarioDto novoUsuarioDto) {
        log.info("Chegou no endpoint de salvar pessoas");
        try {
            Usuario usuario = novoUsuarioMapper.toDomain(novoUsuarioDto);
            return ResponseEntity.ok(pessoaService.save(usuario));

        } catch (UsuarioInvalidoException e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("X-Reason",e.getMessage())
                    .build();
        } catch (UsuarioException e) {
            log.error(e.getMessage(), e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("X-Reason",e.getMessage())
                    .build();
        }
    }
}
