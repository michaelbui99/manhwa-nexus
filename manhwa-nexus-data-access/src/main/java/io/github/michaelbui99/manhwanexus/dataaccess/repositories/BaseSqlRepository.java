package io.github.michaelbui99.manhwanexus.dataaccess.repositories;

import io.github.michaelbui99.manhwanexus.dataaccess.ConnectionProvider;

public class BaseSqlRepository {
    private ConnectionProvider connectionProvider = ConnectionProvider.getInstance();

    public BaseSqlRepository() {
    }

    public void perform(PerformSql func) {
        connectionProvider.connect();
        func.execute(connectionProvider.getConnection());
        connectionProvider.disconnect();
    }
}
