package io.github.michaelbui99.manhwanexus.core.interfaces.service;

import io.github.michaelbui99.manhwanexus.core.models.Manhwa;

import java.util.List;

// NOTE: (michaelbui99 27-12-2022) This will be clarified and implemented at a later point. Out-of-scope for the
// Proof of concept
public interface ManhwaSearchService {
    /**
     * Searches for Manhwas with titles that includes <code>title</code>. Search is also executed on alternate titles.
     *
     * @return List of all Manhwa that includes the <code>title</code>
     */
    List<Manhwa> getByTitle(String title);
}
