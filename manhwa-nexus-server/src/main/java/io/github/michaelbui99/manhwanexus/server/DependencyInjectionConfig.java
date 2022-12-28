package io.github.michaelbui99.manhwanexus.server;

import io.github.michaelbui99.manhwanexus.core.GenreServiceFactoryImpl;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.GenreService;
import io.github.michaelbui99.manhwanexus.dataaccess.repositories.JooqGenreRepositoryFactory;
import io.github.michaelbui99.manhwanexus.server.controllers.GenreController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjectionConfig {
    @Bean
    public GenreService genreService() {
        var genreRespoitoryFactory = new JooqGenreRepositoryFactory();
        var genreServiceFactory = new GenreServiceFactoryImpl(genreRespoitoryFactory);

        return genreServiceFactory.create();
    }

    @Bean
    public GenreController genreController() {
        return new GenreController(genreService());
    }
}
