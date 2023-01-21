package io.github.michaelbui99.manhwanexus.core.exceptions;

/**
 * Exception to throw when infrastructure is down e.g. no connection to DB
 * */
public class InfrastructureException extends RuntimeException {
    public InfrastructureException() {
    }

    public InfrastructureException(String message) {
        super(message);
    }
}
