package io.github.michaelbui.manhwanexus.dataaccess.repositories;

import io.github.michaelbui.manhwanexus.dataaccess.ConnectionProvider;
import io.github.michaelbui99.manhwanexus.core.interfaces.repository.GenreRepository;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.util.List;

public class JooqGenreRepository extends BaseJooqRepository implements GenreRepository {

    public JooqGenreRepository() {
        super();
    }

    @Override
    public String create(String entity) {
        return null;
    }

    @Override
    public String getById(int id) {
        DSLContext create = getDSLContext();
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
