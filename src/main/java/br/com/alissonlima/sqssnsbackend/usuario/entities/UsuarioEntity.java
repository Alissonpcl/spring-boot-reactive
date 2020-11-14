package br.com.alissonlima.sqssnsbackend.usuario.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.time.LocalDateTime;

@Table("usuarios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    private String password;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime dataHoraCriacao;
}
