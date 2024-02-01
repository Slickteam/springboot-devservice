package fr.slickteam.springbootdevservices.database.repository;

import fr.slickteam.springbootdevservices.database.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, UUID> {

}
