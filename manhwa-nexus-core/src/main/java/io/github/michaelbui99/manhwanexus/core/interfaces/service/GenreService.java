package io.github.michaelbui99.manhwanexus.core.interfaces.service;

import java.util.List;

public interface GenreService {
    List<String> getAll();

    String create(String genre);
}
