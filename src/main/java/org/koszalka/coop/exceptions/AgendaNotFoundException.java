package org.koszalka.coop.exceptions;

public class AgendaNotFoundException extends RuntimeException {

    public AgendaNotFoundException(String message) {
        super(message);
    }

    public AgendaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
