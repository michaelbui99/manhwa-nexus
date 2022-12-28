package io.github.michaelbui99.manhwanexus.dataaccess.repositories;

import io.github.michaelbui99.manhwanexus.core.interfaces.repository.TagRepository;

import java.util.List;

public class JooqTagRepository extends BaseJooqRepository implements TagRepository {

    @Override
    public String create(String entity) {

        return null;
    }

    @Override
    public String getById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public String update(int id, String updatedEntity) {
        return null;
    }

    @Override
    public List<String> getAll() {
        return null;
    }
}
