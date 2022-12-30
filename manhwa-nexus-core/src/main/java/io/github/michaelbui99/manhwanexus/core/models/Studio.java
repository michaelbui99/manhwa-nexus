package io.github.michaelbui99.manhwanexus.core.models;

import java.util.List;

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

    public String getOfficialWebsiteURL() {
        return officialWebsiteURL;
    }
}
