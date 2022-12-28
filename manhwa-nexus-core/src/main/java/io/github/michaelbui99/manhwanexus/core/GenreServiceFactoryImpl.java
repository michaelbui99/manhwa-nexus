package io.github.michaelbui99.manhwanexus.core;

import io.github.michaelbui99.manhwanexus.core.interfaces.GenreRepositoryFactory;
import io.github.michaelbui99.manhwanexus.core.interfaces.GenreServiceFactory;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.GenreService;
import io.github.michaelbui99.manhwanexus.core.services.GenreServiceImpl;

public class GenreServiceFactoryImpl implements GenreServiceFactory {
    private GenreRepositoryFactory genreRepositoryFactory;

    public GenreServiceFactoryImpl(GenreRepositoryFactory genreRepositoryFactory) {
        this.genreRepositoryFactory = genreRepositoryFactory;
    }


    @Override
    public GenreService create() {
        var genreRepository = genreRepositoryFactory.create();
        return new GenreServiceImpl(genreRepository);
    }
}
