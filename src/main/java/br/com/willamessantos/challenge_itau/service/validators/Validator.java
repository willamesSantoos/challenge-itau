package br.com.willamessantos.challenge_itau.service.validators;

public interface Validator<T> {
    void validate(T object);
}
