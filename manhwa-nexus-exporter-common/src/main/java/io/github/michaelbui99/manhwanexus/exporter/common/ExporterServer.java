package io.github.michaelbui99.manhwanexus.exporter.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.javalin.Javalin;

public class ExporterServer {
    private final int EXPORTER_PORT = 8778;
    private final Exporter exporter;
    private final Javalin server;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ExporterServer(Exporter exporter) {
        this.exporter = exporter;
        server = Javalin.create();
        setupRoutes(server);
    }
    public void start(){
        this.server.start(this.EXPORTER_PORT);
    }
    private void setupRoutes(Javalin server) {
        server.get("/nexusexporter/releases", ctx -> ctx.result(gson.toJson(this.exporter.getReleaseUpdates())));
        server.get("/nexusexporter/news", ctx -> ctx.result(gson.toJson(this.exporter.getNewsUpdates())));
    }
}
