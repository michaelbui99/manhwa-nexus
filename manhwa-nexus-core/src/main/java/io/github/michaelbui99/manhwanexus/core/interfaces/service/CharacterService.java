package io.github.michaelbui99.manhwanexus.core.interfaces.service;

import io.github.michaelbui99.manhwanexus.core.models.Character;

import java.util.List;

public interface CharacterService {
    Character create(Character character);

    Character getById(int id);

    Character update(int id, Character updatedState);

    List<Character> getByManhwaId(int manhwaId);

    boolean delete(int id);
}
