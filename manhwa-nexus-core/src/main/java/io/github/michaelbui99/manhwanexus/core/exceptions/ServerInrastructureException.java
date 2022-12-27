package io.github.michaelbui99.manhwanexus.core.exceptions;

/**
 * Exception to throw when infrastructure is down e.g. no connection to DB
 * */
public class ServerInrastructureException extends RuntimeException {
    public ServerInrastructureException() {
    }

    public ServerInrastructureException(String message) {
        super(message);
    }
}
