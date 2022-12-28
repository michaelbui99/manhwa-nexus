package io.github.michaelbui99.manhwanexus.server.server;

import io.github.michaelbui99.manhwanexus.core.util.ResourcesHandler;

import java.util.Properties;

public class JavalinManhwaNexusServerFactory implements ManhwaNexusServerFactory {
    private ResourcesHandler configHandler;

    public JavalinManhwaNexusServerFactory(ResourcesHandler configHandler) {
        this.configHandler = configHandler;
    }

    @Override
    public ManhwaNexusServer create(int port) {
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException(String.format("Invalid port %s", port));
        }

        return new JavalinManhwaNexusServer(port);
    }

    @Override
    public ManhwaNexusServer create() {
        Properties serverConfig = configHandler.readPropertyResource("server.properties");

        int port = ServerConstants.DEFAULT_PORT;
        if (serverConfig != null && serverConfig.containsKey("SERVER_PORT")) {
            port = serverConfig.getProperty("SERVER_PORT") != null ? Integer.parseInt(serverConfig.getProperty(
                    "SERVER_PORT")) : ServerConstants.DEFAULT_PORT;
        }

        return new JavalinManhwaNexusServer(port);
    }
}
