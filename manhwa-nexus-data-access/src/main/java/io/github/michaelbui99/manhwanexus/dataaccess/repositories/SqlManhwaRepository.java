package io.github.michaelbui99.manhwanexus.dataaccess.repositories;

import io.github.michaelbui99.manhwanexus.core.exceptions.InfrastructureException;
import io.github.michaelbui99.manhwanexus.core.interfaces.repository.ManhwaRepository;
import io.github.michaelbui99.manhwanexus.core.models.Manhwa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class SqlManhwaRepository extends BaseSqlRepository implements ManhwaRepository {

    @Override
    public Manhwa create(Manhwa entity) {
        return null;
    }

    @Override
    public Manhwa getById(int id) {
        AtomicReference<Manhwa> manhwa = new AtomicReference<>();

        perform(connection -> {
            try {
                PreparedStatement stm = connection.prepareStatement("SELECT id, title, synopsis, chapter_count, volume_count, season_count, start_date, end_date, is_adult, source_material FROM manhwa WHERE id = ?");
                stm.setInt(1, id);
                ResultSet result = stm.executeQuery();

                if (!result.next()){
                    return;
                }

                manhwa.set(new Manhwa())

            } catch (SQLException e) {
                throw new InfrastructureException(e.getMessage());
            }
        });

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
