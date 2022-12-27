package io.github.michaelbui.manhwanexus.dataaccess;

import io.github.michaelbui99.manhwanexus.core.interfaces.repository.ManhwaRepository;
import io.github.michaelbui99.manhwanexus.core.models.Manhwa;

import java.util.List;

public class SqlManhwaRepository implements ManhwaRepository {

    @Override
    public Manhwa create(Manhwa entity) {
        return null;
    }

    @Override
    public Manhwa getById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Manhwa update(int id, Manhwa updatedEntity) {
        return null;
    }

    @Override
    public List<Manhwa> getAll() {
        return null;
    }
}
