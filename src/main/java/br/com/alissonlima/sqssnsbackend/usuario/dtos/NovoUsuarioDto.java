package br.com.alissonlima.sqssnsbackend.usuario.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NovoUsuarioDto {
    private String nome;
    private String email;
    private String password;
}
