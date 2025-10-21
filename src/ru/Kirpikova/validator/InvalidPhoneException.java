package ru.Kirpikova.validator;

public class InvalidPhoneException extends RuntimeException {
    public InvalidPhoneException (String message) {
        super(message);
    }
}
