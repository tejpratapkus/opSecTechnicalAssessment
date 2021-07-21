package com.opsec.assessment.exception;

/**
 * This class is used the Handle UserNotFound exception, if user is not found
 * at runtime
 *
 * @author tkushwaha
 *
 */
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
