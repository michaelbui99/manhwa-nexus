package io.github.michaelbui99.manhwanexus.core.interfaces.service;

import java.util.List;

public interface GenreService {
    List<String> getAll();

    String create(String genre);

    /**
     * Since Manhwa Nexus will get information from various sources, some resolution strategy is needed to resolve
     * genres from other domains to Manhwa Nexus domain, e.g. Scifi --> Sci-Fi
     */
    String tryResolveGenre(String genre);
}
