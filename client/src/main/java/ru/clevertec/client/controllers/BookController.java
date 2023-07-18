package ru.clevertec.client.controllers;

import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.clevertec.client.dto.BookDto;
import ru.clevertec.client.dto.CreateBookDto;
import ru.clevertec.client.dto.UpdateBookDto;
import ru.clevertec.client.models.responses.EditResponse;
import ru.clevertec.client.services.BookService;

import java.net.URI;
import java.util.List;

import static ru.clevertec.client.utils.ErrorMessage.MIN_ID_MESSAGE;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Validated
@RefreshScope
public class BookController {

    private final BookService service;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(service.getAllBooks());
    }

    @GetMapping("{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable @Min(value = 1, message = MIN_ID_MESSAGE) long id) {
        BookDto dto = service.getBookById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EditResponse> addBook(@RequestBody CreateBookDto book) {
        long generatedId = service.addBook(book).getId();
        EditResponse response = new EditResponse("Book added successfully");
        URI uri = UriComponentsBuilder
                .fromPath("books/{id}")
                .buildAndExpand(generatedId).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditResponse> updateBook(@PathVariable @Min(value = 1, message = MIN_ID_MESSAGE) long id,
                                                   @RequestBody UpdateBookDto dto) {
        service.updateBook(id, dto);
        EditResponse response = new EditResponse("Book updated successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EditResponse> deleteBook(@PathVariable @Min(value = 1, message = MIN_ID_MESSAGE) long id) {
        service.deleteBookById(id);
        EditResponse response = new EditResponse("Book deleted successfully");
        return ResponseEntity.ok(response);
    }
}
