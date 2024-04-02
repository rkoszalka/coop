package org.koszalka.coop.exceptions;

public class UserNotAbleToVoteException extends RuntimeException {

    public UserNotAbleToVoteException(String message) {
        super(message);
    }

    public UserNotAbleToVoteException(String message, Throwable cause) {
        super(message, cause);
    }
}
