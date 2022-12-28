package io.github.michaelbui99.manhwanexus.server;

import io.github.michaelbui99.manhwanexus.core.util.ResourcesHandler;
import io.github.michaelbui99.manhwanexus.server.controllers.GenreController;
import io.github.michaelbui99.manhwanexus.server.server.JavalinManhwaNexusServerFactory;
import io.github.michaelbui99.manhwanexus.server.server.ManhwaNexusServer;
import io.github.michaelbui99.manhwanexus.server.server.ManhwaNexusServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunServer {
    public static void main(String[] args) {
        ResourcesHandler handler = new ResourcesHandler();
        ApplicationContext appContext = new AnnotationConfigApplicationContext(DependencyInjectionConfig.class);

        ManhwaNexusServerFactory factory = new JavalinManhwaNexusServerFactory(handler);
        ManhwaNexusServer server = factory.create();
        String apiPrefix = "api/v1/";

        GenreController genreController = appContext.getBean(GenreController.class);

        server.get(apiPrefix + "genres", context -> context.json(genreController.getAll()));

        server.start();
    }
}
