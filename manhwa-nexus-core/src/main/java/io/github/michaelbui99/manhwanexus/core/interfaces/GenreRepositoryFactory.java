package io.github.michaelbui99.manhwanexus.core.interfaces;

import io.github.michaelbui99.manhwanexus.core.interfaces.repository.GenreRepository;

public interface GenreRepositoryFactory {
    GenreRepository create();
}
