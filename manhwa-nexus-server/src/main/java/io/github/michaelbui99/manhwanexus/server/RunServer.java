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
        ApplicationContext appContext = new AnnotationConfigApplicationContext(DependencyInjectionConfig.class);
        ManhwaNexusServer server = appContext.getBean(ManhwaNexusServer.class);
        server.start();
    }
}
