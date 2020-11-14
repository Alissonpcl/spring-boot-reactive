package br.com.alissonlima.sqssnsbackend.usuario.exceptions;

public class UsuarioInvalidoException extends UsuarioException{
    public UsuarioInvalidoException() {
    }

    public UsuarioInvalidoException(String message) {
        super(message);
    }
}
