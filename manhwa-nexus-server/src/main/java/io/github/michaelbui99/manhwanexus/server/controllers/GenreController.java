package io.github.michaelbui99.manhwanexus.server.controllers;

import io.github.michaelbui99.manhwanexus.core.GenreServiceFactoryImpl;
import io.github.michaelbui99.manhwanexus.core.interfaces.GenreServiceFactory;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.GenreService;
import io.github.michaelbui99.manhwanexus.dataaccess.repositories.JooqGenreRepositoryFactory;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    public List<String> getAll(){
        return genreService.getAll();
    }
}
