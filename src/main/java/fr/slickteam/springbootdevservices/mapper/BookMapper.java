package fr.slickteam.springbootdevservices.mapper;

import fr.slickteam.springbootdevservices.api.model.BookDTO;
import fr.slickteam.springbootdevservices.database.entity.Book;

public final class BookMapper {

    private BookMapper() {
        // Private constructor
    }

    public static BookDTO toDTO(Book book) {
        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublisher(), book.getShelfId());
    }

    public static Book toEntity(BookDTO bookDTO) {
        return new Book(bookDTO.id(), bookDTO.title(), bookDTO.author(), bookDTO.isbn(), bookDTO.publisher(), bookDTO.shelf());
    }
}
