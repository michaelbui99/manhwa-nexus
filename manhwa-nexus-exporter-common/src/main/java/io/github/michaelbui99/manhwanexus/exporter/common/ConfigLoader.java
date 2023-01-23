package io.github.michaelbui99.manhwanexus.exporter.common;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ConfigLoader {
    private static Yaml yaml = new Yaml(new Constructor(ExporterConfig.class));

    public static ExporterConfig getExporterConfig(String configPath) throws FileNotFoundException, IllegalStateException {
        InputStream is = new FileInputStream(configPath);
        ExporterConfig config = yaml.load(is);

        if (config == null) {
            throw new IllegalStateException("config was not loaded properly");
        }

        return config;
    }
}
