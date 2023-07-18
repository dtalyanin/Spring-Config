package ru.clevertec.client.services;

import org.springframework.web.bind.annotation.RequestBody;
import ru.clevertec.client.dto.BookDto;
import ru.clevertec.client.dto.CreateBookDto;
import ru.clevertec.client.dto.UpdateBookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks();
    BookDto getBookById(long id);
    BookDto addBook(@RequestBody CreateBookDto book);
    void updateBook(long id, UpdateBookDto dto);
    void deleteBookById(long id);
}
