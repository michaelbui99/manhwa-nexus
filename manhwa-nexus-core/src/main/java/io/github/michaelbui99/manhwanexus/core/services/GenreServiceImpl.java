package io.github.michaelbui99.manhwanexus.core.services;

import io.github.michaelbui99.manhwanexus.core.interfaces.repository.GenreRepository;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.GenreService;
import io.github.michaelbui99.manhwanexus.core.util.MapUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//TODO: Add cache
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
    public List<String> getByManhwa(int manhwaId) {
        return genreRepository.getByManhwa(manhwaId);
    }

    @Override
    public String create(String genre) {
        return genreRepository.create(genre);
    }

    @Override
    public Optional<String> createIfNotExists(String genre) {
        Map<String, Boolean> registeredGenres = MapUtil.fromList(getAll(), true);
        var resolvedGenre = genre;
        if (!registeredGenres.containsKey(genre)) {
            resolvedGenre = tryResolveGenre(genre);
        }

        // Assume the genre is something new that needs to be registered if it wasn't resolved properly
        if (!registeredGenres.containsKey(resolvedGenre)) {
            return Optional.of(create(genre));
        }

        return Optional.empty();
    }

    @Override
    public String tryResolveGenre(String genre) {
        return null;
    }
}