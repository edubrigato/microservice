package br.com.seguros.domain.exception;

public class BadRequest extends IllegalArgumentException{

    public BadRequest(String message) {
        super(message);
    }
}
