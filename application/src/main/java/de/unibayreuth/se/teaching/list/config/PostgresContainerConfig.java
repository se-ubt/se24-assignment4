package de.unibayreuth.se.teaching.list.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;


/**
 * Configuration for Postgres test containers, can also be used for local development.
 */
@TestConfiguration(proxyBeanMethods = false)
@Profile("!prod")
public class PostgresContainerConfig {

    public static PostgreSQLContainer<?> createPostgresContainer() {
        return new PostgreSQLContainer<>(
                DockerImageName.parse("postgres:16-alpine"))
                .withUsername("postgres")
                .withPassword("postgres")
                .withDatabaseName("postgres");
    }

    @Bean
    @ServiceConnection
    public PostgreSQLContainer<?> postgresContainer() {
        return createPostgresContainer();
    }
}
