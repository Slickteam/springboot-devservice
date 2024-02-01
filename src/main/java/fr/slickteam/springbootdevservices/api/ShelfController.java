package fr.slickteam.springbootdevservices.api;

import fr.slickteam.springbootdevservices.api.model.BookDTO;
import fr.slickteam.springbootdevservices.api.model.ShelfDTO;
import fr.slickteam.springbootdevservices.database.repository.BookRepository;
import fr.slickteam.springbootdevservices.database.repository.ShelfRepository;
import fr.slickteam.springbootdevservices.mapper.BookMapper;
import fr.slickteam.springbootdevservices.mapper.ShelfMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shelves")
public class ShelfController {

    private final ShelfRepository shelfRepository;

    private final BookRepository bookRepository;

    public ShelfController(ShelfRepository shelfRepository,
                           BookRepository bookRepository) {
        this.shelfRepository = shelfRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ResponseEntity<List<ShelfDTO>> getAllShelves() {
        return ResponseEntity.ok(shelfRepository.findAll().stream().map(ShelfMapper::toDTO).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<ShelfDTO> getShelfById(@PathVariable UUID id) {
        return ResponseEntity.ok(shelfRepository.findById(id).map(ShelfMapper::toDTO).orElse(null));
    }

    @PutMapping
    public ResponseEntity<ShelfDTO> createOrUpdateShelf(@RequestBody ShelfDTO shelfDTO) {
        return ResponseEntity.ok(ShelfMapper.toDTO(shelfRepository.save(ShelfMapper.toEntity(shelfDTO))));
    }

    @GetMapping("{id}/books")
    public ResponseEntity<List<BookDTO>> getBooksByShelfId(@PathVariable UUID id) {
        return ResponseEntity.ok(bookRepository.findByShelfId(id).stream().map(BookMapper::toDTO).toList());
    }

}
