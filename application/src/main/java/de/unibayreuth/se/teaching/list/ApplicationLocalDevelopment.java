package de.unibayreuth.se.teaching.list;

import de.unibayreuth.se.teaching.list.config.PostgresContainerConfig;
import org.springframework.boot.SpringApplication;

/**
 * Main class to start the Spring Boot application in local development.
 */
public class ApplicationLocalDevelopment {
    public static void main(String[] args) {
        SpringApplication.from(Application::main)
                .with(PostgresContainerConfig.class)
                .run(args);
    }
}
