package io.github.michaelbui99.manhwanexus.dataaccess.repositories;

import io.github.michaelbui99.manhwanexus.core.interfaces.repository.ManhwaRepository;
import io.github.michaelbui99.manhwanexus.core.models.Manhwa;

import java.util.List;

public class JooqManhwaRepository extends BaseJooqRepository implements ManhwaRepository {

    public JooqManhwaRepository() {
        super();
    }

    @Override
    public Manhwa create(Manhwa entity) {
        var create = getDSLContext();
        create.insertInto(io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.Manhwa.MANHWA);
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
