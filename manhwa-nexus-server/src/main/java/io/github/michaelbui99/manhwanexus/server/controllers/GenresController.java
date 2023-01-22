package io.github.michaelbui99.manhwanexus.server.controllers;

import io.github.michaelbui99.manhwanexus.core.interfaces.repository.GenreRepository;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("genres")
public class GenresController {
    private final Logger logger = LoggerFactory.getLogger(GenresController.class);
    private final GenreService genreService;

    @Autowired
    public GenresController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAll() {
        try {
            logger.info("Retrieved GET request for /genres");
            return ResponseEntity.ok(genreService.getAll());
        } catch (Exception e) {
            logger.error(String.format("failed to retrieve all genres: %s", e.getMessage()));
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
