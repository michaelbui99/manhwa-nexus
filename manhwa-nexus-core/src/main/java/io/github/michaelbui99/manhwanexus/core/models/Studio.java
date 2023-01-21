package io.github.michaelbui99.manhwanexus.core.models;

import java.util.List;
import java.util.Optional;

public class Studio {
    private int id;
    private String name;
    private List<Manhwa> listOfWork;
    private String officialWebsiteURL;

    public Studio(int id, String name, List<Manhwa> listOfWork, String officialWebsiteURL) {
        this.id = id;
        this.name = name;
        this.listOfWork = listOfWork;
        this.officialWebsiteURL = officialWebsiteURL;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Manhwa> getListOfWork() {
        return listOfWork;
    }

    public Optional<String> getOfficialWebsiteURL() {
        if (officialWebsiteURL == null || officialWebsiteURL.isEmpty() || officialWebsiteURL.isBlank()) {
            return Optional.empty();
        }
        return Optional.of(officialWebsiteURL);
    }
}
