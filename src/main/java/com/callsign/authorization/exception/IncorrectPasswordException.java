package com.callsign.authorization.exception;

/**
 * @author Shadab Khan
 * @since 09/01/2022
 */
public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(String message) {
        super(message);
    }
}
