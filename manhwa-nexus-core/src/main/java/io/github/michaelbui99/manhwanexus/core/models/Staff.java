package io.github.michaelbui99.manhwanexus.core.models;

import java.time.LocalDate;

public class Staff {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String position;

    public Staff(int id, String firstName, String lastName, LocalDate dateOfBirth, String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPosition() {
        return position;
    }
}
