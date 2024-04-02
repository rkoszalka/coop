package org.koszalka.coop.exceptions;

public class AgendaIsClosedException extends RuntimeException {

    public AgendaIsClosedException(String message) {
        super(message);
    }

    public AgendaIsClosedException(String message, Throwable cause) {
        super(message, cause);
    }
}
