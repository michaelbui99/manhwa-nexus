package io.github.michaelbui99.manhwanexus.server.controllers;

import io.github.michaelbui99.manhwanexus.core.interfaces.service.GenreService;
import io.github.michaelbui99.manhwanexus.server.server.ManhwaNexusServer;

import java.util.List;

public class GenreController extends ControllerBase {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        super();
        this.genreService = genreService;
    }

    public List<String> getAll() {
        return genreService.getAll();
    }

    @Override
    public void applyRoutes(ManhwaNexusServer server) {
        server.get(API_PREFIX + "genres", context -> context.json(getAll()));
    }
}
