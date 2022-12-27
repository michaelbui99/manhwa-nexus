package io.github.michaelbui99.manhwanexus.server;

import io.github.michaelbui99.manhwanexus.core.util.ResourcesHandler;
import io.github.michaelbui99.manhwanexus.server.server.JavalinManhwaNexusServerFactory;
import io.github.michaelbui99.manhwanexus.server.server.ManhwaNexusServer;
import io.github.michaelbui99.manhwanexus.server.server.ManhwaNexusServerFactory;

public class RunServer {
    public static void main(String[] args) {
        ResourcesHandler handler = new ResourcesHandler();

        ManhwaNexusServerFactory factory = new JavalinManhwaNexusServerFactory(handler);
        ManhwaNexusServer server = factory.create();

        server.start();
    }
}
