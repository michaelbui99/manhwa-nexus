package io.github.michaelbui99.manhwanexus.server;

import io.github.michaelbui99.manhwanexus.core.interfaces.repository.GenreRepository;
import io.github.michaelbui99.manhwanexus.dataaccess.repositories.SqlGenreRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManhwaNexusServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManhwaNexusServerApplication.class, args);
    }

    @Bean
    public GenreRepository genreRepository(){
        return new SqlGenreRepository();
    }
}
