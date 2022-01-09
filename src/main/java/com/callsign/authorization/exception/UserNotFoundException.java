package com.callsign.authorization.exception;

/**
 * @author Shadab Khan
 * @since 09/01/2022
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
