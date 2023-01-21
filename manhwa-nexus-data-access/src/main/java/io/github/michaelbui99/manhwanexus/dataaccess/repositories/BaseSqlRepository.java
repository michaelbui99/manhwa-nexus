package io.github.michaelbui99.manhwanexus.dataaccess.repositories;

import io.github.michaelbui99.manhwanexus.dataaccess.ConnectionProvider;

import java.sql.Connection;
import java.util.function.Consumer;

public class BaseSqlRepository {
    private ConnectionProvider connectionProvider = ConnectionProvider.getInstance();

    public BaseSqlRepository() {
    }

    public void perform(Consumer<Connection> perform) {
        connectionProvider.connect();
        perform.accept(connectionProvider.getConnection());
        connectionProvider.disconnect();
    }
}
