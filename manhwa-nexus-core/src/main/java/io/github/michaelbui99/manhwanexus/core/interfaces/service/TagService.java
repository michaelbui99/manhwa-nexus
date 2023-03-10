package io.github.michaelbui99.manhwanexus.core.interfaces.service;

import java.util.List;
import java.util.Optional;

public interface TagService {
    List<String> getAll();
    List<String> getByManhwa(int manhwaId);

    String create(String tag);
    Optional<String> createIfNotExists(String tag);

    /**
     * Since Manhwa Nexus will get information from various sources, some resolution strategy is needed to resolve
     * tags from other domains to Manhwa Nexus domain.
     */
    String tryResolveTag(String tag);
}
