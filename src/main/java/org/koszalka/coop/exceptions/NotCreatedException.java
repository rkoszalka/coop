package org.koszalka.coop.exceptions;

public class NotCreatedException extends RuntimeException {

    public NotCreatedException(String message) {
        super(message);
    }

    public NotCreatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
