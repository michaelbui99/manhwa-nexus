package io.github.michaelbui99.manhwanexus.dataaccess.repositories;

import io.github.michaelbui99.manhwanexus.core.interfaces.GenreRepositoryFactory;
import io.github.michaelbui99.manhwanexus.core.interfaces.repository.GenreRepository;

public class JooqGenreRepositoryFactory implements GenreRepositoryFactory {
    @Override
    public GenreRepository create() {
        return new JooqGenreRepository();
    }
}
