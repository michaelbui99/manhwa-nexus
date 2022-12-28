package io.github.michaelbui99.manhwanexus.core.services;

import io.github.michaelbui99.manhwanexus.core.interfaces.repository.GenreRepository;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.GenreService;

import java.util.List;

public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<String> getAll() {
        return genreRepository.getAll();
    }

    @Override
    public String create(String genre) {
        return genreRepository.create(genre);
    }
}