package io.github.michaelbui99.manhwanexus.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionProvider {
    private String user = System.getenv("DB_USER");
    private String password = System.getenv("DB_PASSWORD");
    private String schema = System.getenv("DB_SCHEMA");
    private String url = String.format("jdbc:postgresql://%s:%s/%s?currentSchema=%s", System.getenv("DB_HOST"), System.getenv("DB_PORT")
            , System.getenv("DB_DB"), schema);
    private Connection connection;
    private boolean connected = false;
    private static ConnectionProvider instance;
    private final static ReentrantLock lock = new ReentrantLock();

    private ConnectionProvider() {
    }

    public static ConnectionProvider getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ConnectionProvider();
                }
            }
        }

        return instance;
    }

    public void connect() {
        synchronized (lock) {
            if (connected) {
                return;
            }

            try {
                connection = DriverManager.getConnection(url, user, password);
                connected = true;
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void disconnect() {
        synchronized (lock) {
            if (!connected) {
                return;
            }

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        if (!connected) {
            throw new IllegalStateException("Currently disconnected from database");
        }

        return connection;
    }

    public boolean isConnected() {
        return connected;
    }
}
