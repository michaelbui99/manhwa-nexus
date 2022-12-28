package io.github.michaelbui99.manhwanexus.dataaccess.repositories;

import io.github.michaelbui99.manhwanexus.core.interfaces.repository.GenreRepository;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.Genre;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class JooqGenreRepository extends BaseJooqRepository implements GenreRepository {

    public JooqGenreRepository() {
        super();
    }

    @Override
    public String create(String entity) {
        var create = getDSLContext();
        int result = create.insertInto(Genre.GENRE).values(entity).execute();

        if (result == 0) {
            return null;
        }

        return entity;
    }

    @Override
    public String getById(int id) {
        var create = getDSLContext();
        Result<Record> result = create.select().from(Genre.GENRE).where(Genre.GENRE.ID.eq(id)).fetch();

        for (Record r : result) {
            return r.getValue(Genre.GENRE.GENRE_);
        }

        throw new NoSuchElementException();
    }

    @Override
    public boolean delete(int id) {
        var create = getDSLContext();
        var result = create.deleteFrom(Genre.GENRE).where(Genre.GENRE.ID.eq(id)).execute();
        return result > 0;
    }

    @Override
    public String update(int id, String updatedEntity) {
        return null;
    }

    @Override
    public List<String> getAll() {
        List<String> genres = new ArrayList<>();
        var create = getDSLContext();
        var result = create.select().from(Genre.GENRE).fetch();

        result.forEach(res -> {
            genres.add(res.getValue(Genre.GENRE.GENRE_));
        });

        return genres;
    }
}
