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
        if (!connectionProvider.isConnected()) {
            retryConnection(3);
        }
        perform.accept(connectionProvider.getConnection());
//        connectionProvider.disconnect();
    }

    private void retryConnection(int retryCount) {
        int count = 0;
        while (count < retryCount) {
            connectionProvider.connect();
            if (connectionProvider.isConnected()) {
                return;
            }

            try {
                count++;
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
