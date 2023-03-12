package com.mrv.exception;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ASYXProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ASYXProductNotFoundException(String message) {
        super(message);
    }

    public ASYXProductNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
