package io.github.michaelbui99.manhwanexus.server;

import io.github.michaelbui99.manhwanexus.core.GenreServiceFactoryImpl;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.GenreService;
import io.github.michaelbui99.manhwanexus.core.util.ResourcesHandler;
import io.github.michaelbui99.manhwanexus.dataaccess.repositories.JooqGenreRepositoryFactory;
import io.github.michaelbui99.manhwanexus.server.controllers.GenreController;
import io.github.michaelbui99.manhwanexus.server.installers.ControllerInstaller;
import io.github.michaelbui99.manhwanexus.server.server.JavalinManhwaNexusServerFactory;
import io.github.michaelbui99.manhwanexus.server.server.ManhwaNexusServer;
import io.github.michaelbui99.manhwanexus.server.server.ManhwaNexusServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DependencyInjectionConfig {
    @Bean
    public GenreService genreService() {
        var genreRespositoryFactory = new JooqGenreRepositoryFactory();
        var genreServiceFactory = new GenreServiceFactoryImpl(genreRespositoryFactory);

        return genreServiceFactory.create();
    }

    @Bean
    public GenreController genreController() {
        var controller = new GenreController(genreService());
        controllerInstaller().installController(controller);
        return controller;
    }

    @Bean
    public ControllerInstaller controllerInstaller() {
        return new ControllerInstaller(manhwaNexusServer());
    }

    @Bean
    public ResourcesHandler resourcesHandler() {
        return new ResourcesHandler();
    }

    @Bean()
    @Scope("singleton")
    public ManhwaNexusServer manhwaNexusServer() {
        ManhwaNexusServerFactory factory = new JavalinManhwaNexusServerFactory(resourcesHandler());
        return factory.create();
    }
}
