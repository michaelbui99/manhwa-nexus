package io.github.michaelbui99.manhwanexus.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManhwaNexusServerApplication {
    private final static Logger logger = LoggerFactory.getLogger(ManhwaNexusServerApplication.class);

    public static void main(String[] args) {
        logger.info("""
                  __  __             _                    _   _                       ____                          \s
                 |  \\/  | __ _ _ __ | |____      ____ _  | \\ | | _____  ___   _ ___  / ___|  ___ _ ____   _____ _ __\s
                 | |\\/| |/ _` | '_ \\| '_ \\ \\ /\\ / / _` | |  \\| |/ _ \\ \\/ / | | / __| \\___ \\ / _ \\ '__\\ \\ / / _ \\ '__|
                 | |  | | (_| | | | | | | \\ V  V / (_| | | |\\  |  __/>  <| |_| \\__ \\  ___) |  __/ |   \\ V /  __/ |  \s
                 |_|  |_|\\__,_|_| |_|_| |_|\\_/\\_/ \\__,_| |_| \\_|\\___/_/\\_\\\\__,_|___/ |____/ \\___|_|    \\_/ \\___|_|  \s
                                                                                                                    \s
                """);
        SpringApplication.run(ManhwaNexusServerApplication.class, args);
    }

}

