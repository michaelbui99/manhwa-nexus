package io.github.michaelbui99.manhwanexus.core.models;

public enum Status {
    FINISHED("Finished"),
    RELEASING("Releasing"),
    NOT_YET_RELEASED("Not yet released"),
    CANCELLED("Cancelled"),
    HIATUS("Hiatus");

    private final String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
