package io.github.michaelbui99.manhwanexus.core.models;

import java.util.List;

public class Character {
    private String name;
    private int age;
    private List<String> titles;
    private String race;
    private List<Character> relatives;
    private String occupation;
    private CharacterStatus status;
    private String description;

    public Character(String name, int age, List<String> titles, String race, List<Character> relatives,
                     String occupation, CharacterStatus status, String description) {
        this.name = name;
        this.age = age;
        this.titles = titles;
        this.race = race;
        this.relatives = relatives;
        this.occupation = occupation;
        this.status = status;
        this.description = description;
    }
}
