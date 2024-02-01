package fr.slickteam.springbootdevservices.mapper;

import fr.slickteam.springbootdevservices.api.model.ShelfDTO;
import fr.slickteam.springbootdevservices.database.entity.Shelf;

public final class ShelfMapper {

    private ShelfMapper() {
        // Private constructor
    }

    public static ShelfDTO toDTO(Shelf shelf) {
        return new ShelfDTO(shelf.getId(), shelf.getName());
    }

    public static Shelf toEntity(ShelfDTO shelfDTO) {
        return new Shelf(shelfDTO.id(), shelfDTO.name());
    }
}
