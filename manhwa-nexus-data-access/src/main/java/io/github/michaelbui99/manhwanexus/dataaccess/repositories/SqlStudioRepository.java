package io.github.michaelbui99.manhwanexus.dataaccess.repositories;

import io.github.michaelbui99.manhwanexus.core.exceptions.InfrastructureException;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.StudioService;
import io.github.michaelbui99.manhwanexus.core.models.Manhwa;
import io.github.michaelbui99.manhwanexus.core.models.Studio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class SqlStudioRepository extends BaseSqlRepository implements StudioService {
    @Override
    public Studio create(Studio studio) {
        AtomicReference<Studio> createdStudio = new AtomicReference<>();

        perform(connection -> {
            try {
                PreparedStatement stm = connection.prepareStatement("INSERT INTO studio(name, official_website_url) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, studio.getName());
                studio.getOfficialWebsiteURL().ifPresent(website -> {
                    try {
                        stm.setString(2, website);
                    } catch (SQLException e) {
                        throw new InfrastructureException(e.getMessage());
                    }
                });

                ResultSet keys = stm.getGeneratedKeys();
                keys.next();
                int id = keys.getInt(1);

                createdStudio.set(new Studio(id, studio.getName(), new ArrayList<>(), studio.getOfficialWebsiteURL().orElse(null)));
            } catch (SQLException e) {
                throw new InfrastructureException(e.getMessage());
            }
        });

        return createdStudio.get();
    }

    @Override
    public Studio getById(int id) {
        AtomicReference<Studio> existingStudio = new AtomicReference<>();

        perform(connection -> {
            try {
                PreparedStatement stm = connection.prepareStatement("SELECT id, name, official_website_url FROM studio WHERE id = ?");
                ResultSet result = stm.executeQuery();

                if (result.next()) {
                    existingStudio.set(new Studio(result.getInt("id"), result.getString("name"), new ArrayList<>(), result.getString("official_website_url")));
                }

            } catch (SQLException e) {
                throw new InfrastructureException(e.getMessage());
            }
        });

        return existingStudio.get();
    }

    @Override
    public boolean exists(int id) {
        AtomicReference<Boolean> result = new AtomicReference<>();

        perform(connection -> {
            try {
                PreparedStatement stm = connection.prepareStatement("SELECT id FROM studio WHERE id = ?");
                ResultSet results = stm.executeQuery();
                result.set(results.next());
            } catch (SQLException e) {
                throw new InfrastructureException(e.getMessage());
            }
        });

        return result.get();
    }

    @Override
    public boolean exists(String name) {
        AtomicReference<Boolean> result = new AtomicReference<>();

        perform(connection -> {
            try {
                PreparedStatement stm = connection.prepareStatement("SELECT id FROM studio WHERE name = ?");
                ResultSet results = stm.executeQuery();
                result.set(results.next());
            } catch (SQLException e) {
                throw new InfrastructureException(e.getMessage());
            }
        });

        return result.get();
    }

    @Override
    public StudioService addListedWork(int studioId, Manhwa manhwa) {
        return null;
    }
}
