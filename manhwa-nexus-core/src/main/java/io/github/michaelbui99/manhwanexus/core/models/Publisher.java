package io.github.michaelbui99.manhwanexus.core.models;

import java.util.List;

public class Publisher {
    private int id;
    private String name;
    private List<Manhwa> publishedManhwas;

    public Publisher(int id, String name, List<Manhwa> publishedManhwas) {
        this.id = id;
        this.name = name;
        this.publishedManhwas = publishedManhwas;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Manhwa> getPublishedManhwas() {
        return publishedManhwas;
    }
}
