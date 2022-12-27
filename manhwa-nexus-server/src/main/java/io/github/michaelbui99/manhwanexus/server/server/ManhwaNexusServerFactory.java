package io.github.michaelbui99.manhwanexus.server.server;

public interface ManhwaNexusServerFactory {
    public ManhwaNexusServer create(int port);
    public ManhwaNexusServer create();
}
