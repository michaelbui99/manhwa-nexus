package io.github.michaelbui99.manhwanexus.core.interfaces.service;

import io.github.michaelbui99.manhwanexus.core.models.Manhwa;
import io.github.michaelbui99.manhwanexus.core.models.Studio;

public interface StudioService {
    Studio create(Studio studio);

    Studio getById(int id);

    boolean exists(int id);

    boolean exists(String name);

    StudioService addListedWork(int studioId, Manhwa manhwa);
}
