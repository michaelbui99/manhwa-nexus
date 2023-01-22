package io.github.michaelbui99.manhwanexus.server.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.michaelbui99.manhwanexus.server.typeadapters.LocalDateTypeAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonSerializationBeans {
    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTypeAdapter.class, new LocalDateTypeAdapter())
                .setPrettyPrinting()
                .create();
    }
}
