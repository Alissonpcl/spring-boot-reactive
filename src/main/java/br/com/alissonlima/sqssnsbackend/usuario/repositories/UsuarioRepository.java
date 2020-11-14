package br.com.alissonlima.sqssnsbackend.usuario.repositories;

import br.com.alissonlima.sqssnsbackend.usuario.entities.UsuarioEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends ReactiveCrudRepository<UsuarioEntity, Long> {
}
