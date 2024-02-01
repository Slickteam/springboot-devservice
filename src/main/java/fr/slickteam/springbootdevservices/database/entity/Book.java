package fr.slickteam.springbootdevservices.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Book {

    @Id
    private UUID id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String isbn;

    @Column
    private String publisher;

    @Column
    private UUID shelfId;

}
