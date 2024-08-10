package br.com.seguros.application.exception;

public class BadRequest extends IllegalArgumentException{

    public BadRequest(String message) {
        super(message);
    }
}
