package io.github.michaelbui99.manhwanexus.dataaccess.repositories;

import io.github.michaelbui99.manhwanexus.core.interfaces.repository.GenreRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlGenreRepository extends BaseSqlRepository implements GenreRepository {

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
        List<String> genres = new ArrayList<>();

        perform((connection) -> {
            try {
                PreparedStatement stm = connection.prepareStatement("SELECT genre from genre");
                ResultSet result = stm.executeQuery();

                while (result.next()) {
                    genres.add(result.getString("genre"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        return genres;
    }
}
