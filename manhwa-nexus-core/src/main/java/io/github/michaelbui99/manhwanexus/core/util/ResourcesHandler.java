package io.github.michaelbui99.manhwanexus.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.stream.Collectors;

public class ResourcesHandler {
    public ResourcesHandler() {
    }

    public Properties readPropertyResource(String file) {
        try {
            var properties = new Properties();
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(file));
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(String.format("Failed to load file: %s", file));
        }
    }

    public String getResourceFileContent(String file) {
        return new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(file)))
                .lines()
                .collect(Collectors.joining("\n"));
    }
}
