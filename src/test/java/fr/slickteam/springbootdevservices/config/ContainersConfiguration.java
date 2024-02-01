package fr.slickteam.springbootdevservices.config;

import dasniko.testcontainers.keycloak.KeycloakContainer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

@TestConfiguration(proxyBeanMethods = false)
public class ContainersConfiguration {

    static Network network = Network.newNetwork();

    @Bean
    @ServiceConnection
    public PostgreSQLContainer<?> postgreSQLContainer() {
        PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer("postgres:15-alpine")
                .withDatabaseName("springbootdevservices")
                .withUsername("dev")
                .withPassword("pass");
        postgreSQLContainer.withNetwork(network);
        postgreSQLContainer.setPortBindings(List.of("30000:5432"));
        return postgreSQLContainer;
    }

    @Bean
    public KeycloakContainer keycloakContainer() {
        KeycloakContainer keycloakContainer = new KeycloakContainer()
                .withNetwork(network)
                .withRealmImportFile("realm-export.json");
        keycloakContainer.setPortBindings(List.of("8080:8080"));
        return keycloakContainer;
    }
}
