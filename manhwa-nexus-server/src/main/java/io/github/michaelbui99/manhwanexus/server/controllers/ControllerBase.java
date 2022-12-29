package io.github.michaelbui99.manhwanexus.server.controllers;

import io.github.michaelbui99.manhwanexus.server.server.ManhwaNexusServer;

public abstract class ControllerBase implements ManhwaNexusController {
    protected final String API_PREFIX = "api/v1/";

    public ControllerBase(){
    }

    public abstract void applyRoutes(ManhwaNexusServer server);
}
