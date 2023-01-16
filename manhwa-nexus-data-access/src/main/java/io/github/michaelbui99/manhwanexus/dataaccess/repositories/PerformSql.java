package io.github.michaelbui99.manhwanexus.dataaccess.repositories;

import java.sql.Connection;

public interface PerformSql {
    void execute(Connection connection);
}
