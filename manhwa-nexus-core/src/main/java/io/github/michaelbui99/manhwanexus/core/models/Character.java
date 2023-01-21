package io.github.michaelbui99.manhwanexus.core.models;

import java.util.List;
import java.util.Map;

public class Character {
    private int id;
    private String name;
    // TODO: Take a look at this again, since character can age as the series progress.
    private int age;
    private List<String> titles;
    private String race;
    private List<Character> relatives;
    private String occupation;
    private CharacterStatus status;
    private String description;

    /**
     * Manhwa-specific attributes.
     * Key = Attribute name
     * Value = Content
     * e.g. "Weapon(s)" : "BF Sword"
     */
    private Map<String, String> manhwaSpecificAttributes;

    public Character(int id, String name, int age, List<String> titles, String race, List<Character> relatives,
                     String occupation, CharacterStatus status, String description, Map<String, String> manhwaSpecificAttributes) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.titles = titles;
        this.race = race;
        this.relatives = relatives;
        this.occupation = occupation;
        this.status = status;
        this.description = description;
        this.manhwaSpecificAttributes = manhwaSpecificAttributes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getTitles() {
        return titles;
    }

    public String getRace() {
        return race;
    }

    public List<Character> getRelatives() {
        return relatives;
    }

    public String getOccupation() {
        return occupation;
    }

    public CharacterStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
