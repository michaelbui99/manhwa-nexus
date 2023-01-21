package io.github.michaelbui99.manhwanexus.core.interfaces.service;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<String> getAll();
    List<String> getByManhwa(int manhwaId);
    String create(String genre);
    Optional<String> createIfNotExists(String genre);

    /**
     * Since Manhwa Nexus will get information from various sources, some resolution strategy is needed to resolve
     * genres from other domains to Manhwa Nexus domain, e.g. Scifi --> Sci-Fi
     */
    String tryResolveGenre(String genre);
}
