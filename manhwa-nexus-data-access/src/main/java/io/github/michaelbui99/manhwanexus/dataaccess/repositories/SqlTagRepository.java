package io.github.michaelbui99.manhwanexus.dataaccess.repositories;

import io.github.michaelbui99.manhwanexus.core.exceptions.InfrastructureException;
import io.github.michaelbui99.manhwanexus.core.interfaces.repository.TagRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class SqlTagRepository  extends BaseSqlRepository implements TagRepository {
    @Override
    public String create(String entity) {
        AtomicReference<String> createdTag = new AtomicReference<>();

        perform(connection -> {
            try {
                PreparedStatement stm = connection.prepareStatement("INSERT INTO tag(tag) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, entity);
                ResultSet generatedKeys = stm.getGeneratedKeys();

                if (generatedKeys.next()) {
                    connection.commit();
                    createdTag.set(entity);
                }

            } catch (SQLException e) {
                throw new InfrastructureException(e.getMessage());
            }
        });

        return createdTag.get();
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
        List<String> tags = new ArrayList<>();

        perform((connection) -> {
            try {
                PreparedStatement stm = connection.prepareStatement("SELECT tag from tag");
                ResultSet result = stm.executeQuery();

                while (result.next()) {
                    tags.add(result.getString("tag"));
                }
            } catch (SQLException e) {
                throw new InfrastructureException(e.getMessage());
            }
        });

        return tags;
    }
}
