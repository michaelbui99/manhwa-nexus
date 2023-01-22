package io.github.michaelbui99.manhwanexus.dataaccess.repositories;

import io.github.michaelbui99.manhwanexus.core.exceptions.InfrastructureException;
import io.github.michaelbui99.manhwanexus.core.interfaces.repository.ManhwaRepository;
import io.github.michaelbui99.manhwanexus.core.models.*;

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
                List<Manhwa> hits = getManhwasFromResultSet(result);
                if (!hits.isEmpty()) {
                    manhwa.set(hits.get(0));
                }
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

        AtomicReference<List<Manhwa>> allManhwas = new AtomicReference<>(new ArrayList<>());
        perform(connection -> {
            try {
                PreparedStatement stm = connection.prepareStatement("SELECT manhwa.id, title, synopsis, chapter_count, volume_count, season_count, start_date, end_date, is_adult, source_material, code, cover_url, status FROM manhwa join country_code on country_code.id = country_of_origin_id");
                ResultSet results = stm.executeQuery();
                allManhwas.set(getManhwasFromResultSet(results));
            } catch (SQLException e) {
                throw new InfrastructureException(e.getMessage());
            }
        });

        return allManhwas.get();
    }

    private List<Manhwa> getManhwasFromResultSet(ResultSet results) {
        try {
            List<Manhwa> manhwas = new ArrayList<>();
            while (results.next()) {
                Date startDate = results.getDate("start_date");
                Date endDate = results.getDate("end_date");
                String coverUrl = results.getString("cover_url");
                ManhwaBuilder builder = Manhwa.create(
                        results.getInt("id"),
                        results.getString("title"),
                        new ArrayList<>(),
                        Source.valueOf(results.getString("source_material")),
                        CountryCode.valueOf(results.getString("code")), Status.valueOf(results.getString("status")));
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

                if (coverUrl != null) {
                    builder.coverUlr(coverUrl);
                }
                manhwas.add(builder.build());
            }

            return manhwas;
        } catch (SQLException e) {
            throw new InfrastructureException(e.getMessage());
        }
    }
}
