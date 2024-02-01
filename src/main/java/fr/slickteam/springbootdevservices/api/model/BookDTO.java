package fr.slickteam.springbootdevservices.api.model;

import java.util.UUID;

public record BookDTO(UUID id, String title, String author, String isbn, String publisher, UUID shelf) {
}
