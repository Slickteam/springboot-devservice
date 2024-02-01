package fr.slickteam.springbootdevservices.tests;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class DatabaseIT {

    @Container
    @ServiceConnection
    static DatabaseContainer databaseContainer = DatabaseContainer.getInstance();

}
