package io.github.michaelbui99.manhwanexus.dataaccess.repositories;

import io.github.michaelbui99.manhwanexus.core.exceptions.InfrastructureException;
import io.github.michaelbui99.manhwanexus.core.interfaces.repository.ManhwaRepository;
import io.github.michaelbui99.manhwanexus.core.models.CountryCode;
import io.github.michaelbui99.manhwanexus.core.models.Manhwa;
import io.github.michaelbui99.manhwanexus.core.models.ManhwaBuilder;
import io.github.michaelbui99.manhwanexus.core.models.Source;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
                PreparedStatement stm = connection.prepareStatement("SELECT manhwa.id, title, synopsis, chapter_count, volume_count, season_count, start_date, end_date, is_adult, source_material FROM manhwa join country_code on country_code.id = country_of_origin_id WHERE id = ?");
                stm.setInt(1, id);
                ResultSet result = stm.executeQuery();

                if (!result.next()) {
                    return;
                }

                manhwa.set(Manhwa.create(
                        result.getInt("id"),
                        result.getString("title"),
                        new ArrayList<>(),
                        Source.valueOf(result.getString("source_material")),
                        CountryCode.valueOf(result.getString("code"))).build());
            } catch (SQLException e) {
                throw new InfrastructureException(e.getMessage());
            }
        });

        return manhwa.get();
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
        List<Manhwa> allManhwas = new ArrayList<>();

        perform(connection -> {
            try {
                PreparedStatement stm = connection.prepareStatement("SELECT manhwa.id, title, synopsis, chapter_count, volume_count, season_count, start_date, end_date, is_adult, source_material, code FROM manhwa join country_code on country_code.id = country_of_origin_id");
                ResultSet results = stm.executeQuery();

                while (results.next()) {
                    Date startDate = results.getDate("start_date");
                    Date endDate = results.getDate("end_date");
                    ManhwaBuilder builder = Manhwa.create(
                            results.getInt("id"),
                            results.getString("title"),
                            new ArrayList<>(),
                            Source.valueOf(results.getString("source_material")),
                            CountryCode.valueOf(results.getString("code")));
                    builder.synopsis(results.getString("synopsis"));
                    builder.chapterCount(results.getInt("chapter_count"));
                    builder.volumeCount(results.getInt("volume_count"));
                    builder.seasonCount(results.getInt("season_count"));

                    if (startDate != null) {
                        builder.startDate(startDate.toLocalDate());
                    }
                    if (endDate != null) {
                        builder.endDate(endDate.toLocalDate());
                    }

                    allManhwas.add(builder.build());
                }
            } catch (SQLException e) {
                throw new InfrastructureException(e.getMessage());
            }
        });

        return allManhwas;
    }
}
