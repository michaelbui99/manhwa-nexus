package io.github.michaelbui99.manhwanexus.server.server;

import io.javalin.Javalin;

public class JavalinManhwaNexusServer implements ManhwaNexusServer {
    private final int port;
    private final Javalin app;

    public JavalinManhwaNexusServer(int port) {
        this.port = port;
        this.app = Javalin.create();
    }


    @Override
    public void start() {
        System.out.println("Starting server...");
        app.start(port);
    }
}
