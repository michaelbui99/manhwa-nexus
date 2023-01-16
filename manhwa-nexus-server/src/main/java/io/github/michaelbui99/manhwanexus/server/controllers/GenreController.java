package io.github.michaelbui99.manhwanexus.server.controllers;

import io.github.michaelbui99.manhwanexus.core.interfaces.repository.GenreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("genres")
public class GenreController {
    private final Logger LOGGER = LoggerFactory.getLogger(GenreController.class);
    private final GenreRepository genreRepository;

    @Autowired
    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAll() {
        try {
            return ResponseEntity.ok(genreRepository.getAll());
        } catch (Exception e) {
            LOGGER.error("Failed to retrieve genres: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
