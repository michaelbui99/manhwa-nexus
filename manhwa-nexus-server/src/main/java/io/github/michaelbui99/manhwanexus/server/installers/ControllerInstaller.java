package io.github.michaelbui99.manhwanexus.server.installers;

import io.github.michaelbui99.manhwanexus.server.controllers.ManhwaNexusController;
import io.github.michaelbui99.manhwanexus.server.server.ManhwaNexusServer;

public class ControllerInstaller {
    private ManhwaNexusServer server;

    public ControllerInstaller(ManhwaNexusServer server) {
        this.server = server;
    }

    public void installController(ManhwaNexusController controller) {
        controller.applyRoutes(server);
    }
}
