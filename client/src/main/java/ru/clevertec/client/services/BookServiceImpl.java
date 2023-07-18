package ru.clevertec.client.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.clevertec.client.dao.BookRepository;
import ru.clevertec.client.dto.BookDto;
import ru.clevertec.client.dto.CreateBookDto;
import ru.clevertec.client.dto.UpdateBookDto;
import ru.clevertec.client.exceptions.ErrorCode;
import ru.clevertec.client.exceptions.NotFoundException;
import ru.clevertec.client.models.Book;
import ru.clevertec.client.utils.BookMapper;

import java.util.List;
import java.util.Optional;

import static ru.clevertec.client.utils.ErrorMessage.BOOK_WITH_ID_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
@RefreshScope
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final BookMapper mapper;

    @Value("${app.info}")
    private String additionalInfo;

    @Override
    public List<BookDto> getAllBooks() {
        log.info("GET ALL BOOKS");
        return mapper.convertAllToDtos(repository.findAll());
    }

    @Override
    public BookDto getBookById(long id) {
        log.info("GET BOOK BY ID");
        Book book = getBookByIdOrElseThrow(id);
        BookDto dto = mapper.convertToDto(book);
        dto.setTitle(book.getTitle() + " - " + additionalInfo);
        return dto;
    }

    @Override
    public BookDto addBook(@RequestBody CreateBookDto dto) {
        log.info("ADD BOOK");
        Book createdBook = mapper.convertCreateDtoToBook(dto);
        repository.save(createdBook);
        return mapper.convertToDto(createdBook);
    }

    @Override
    public void updateBook(long id, UpdateBookDto dto) {
        log.info("UPDATE BOOK");
        Book updatedBook = getBookByIdOrElseThrow(id);
        mapper.updateBook(dto, updatedBook);
        repository.save(updatedBook);
    }

    @Override
    public void deleteBookById(long id) {
        log.info("DELETE BOOK");
        Book book = getBookByIdOrElseThrow(id);
        repository.delete(book);
    }

    private Book getBookByIdOrElseThrow(long id) {
        Optional<Book> book = repository.findById(id);
        if (book.isEmpty()) {
            throw new NotFoundException(BOOK_WITH_ID_NOT_FOUND, id, ErrorCode.NOT_FOUND);
        }
        return book.get();
    }
}
