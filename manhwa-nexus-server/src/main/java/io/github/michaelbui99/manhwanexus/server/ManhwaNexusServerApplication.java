package io.github.michaelbui99.manhwanexus.server;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.michaelbui99.manhwanexus.core.interfaces.repository.GenreRepository;
import io.github.michaelbui99.manhwanexus.core.interfaces.repository.ManhwaRepository;
import io.github.michaelbui99.manhwanexus.core.interfaces.repository.TagRepository;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.CharacterService;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.GenreService;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.ManhwaService;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.TagService;
import io.github.michaelbui99.manhwanexus.core.services.GenreServiceImpl;
import io.github.michaelbui99.manhwanexus.core.services.ManhwaServiceImpl;
import io.github.michaelbui99.manhwanexus.core.services.TagServiceImpl;
import io.github.michaelbui99.manhwanexus.dataaccess.repositories.SqlGenreRepository;
import io.github.michaelbui99.manhwanexus.dataaccess.repositories.SqlManhwaRepository;
import io.github.michaelbui99.manhwanexus.dataaccess.repositories.SqlTagRepository;
import io.github.michaelbui99.manhwanexus.server.typeadapters.LocalDateTypeAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManhwaNexusServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManhwaNexusServerApplication.class, args);
    }

}

