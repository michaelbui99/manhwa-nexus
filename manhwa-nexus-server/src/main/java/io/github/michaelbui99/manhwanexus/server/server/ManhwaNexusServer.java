package io.github.michaelbui99.manhwanexus.server.server;

import io.javalin.http.Context;

public interface ManhwaNexusServer {
    public interface Handler {
        void execute(Context context);
    }

    public void start();

    public void get(String path, Handler handler);
}
