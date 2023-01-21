package io.github.michaelbui99.manhwanexus.dataaccess.repositories;

import io.github.michaelbui99.manhwanexus.core.exceptions.InfrastructureException;
import io.github.michaelbui99.manhwanexus.core.interfaces.repository.GenreRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class SqlGenreRepository extends BaseSqlRepository implements GenreRepository {

    @Override
    public String create(String entity) {
        AtomicReference<String> createdGenre = new AtomicReference<>();

        perform(connection -> {
            try {
                PreparedStatement stm = connection.prepareStatement("INSERT INTO genre(genre) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, entity);
                ResultSet generatedKeys = stm.getGeneratedKeys();

                if (generatedKeys.next()) {
                    connection.commit();
                    createdGenre.set(entity);
                }

            } catch (SQLException e) {
                throw new InfrastructureException(e.getMessage());
            }
        });

        return createdGenre.get();
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
        List<String> genres = new ArrayList<>();

        perform((connection) -> {
            try {
                PreparedStatement stm = connection.prepareStatement("SELECT genre from genre");
                ResultSet result = stm.executeQuery();

                while (result.next()) {
                    genres.add(result.getString("genre"));
                }
            } catch (SQLException e) {
                throw new InfrastructureException(e.getMessage());
            }
        });

        return genres;
    }
}
