package ru.clevertec.client.utils;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.clevertec.client.dto.BookDto;
import ru.clevertec.client.dto.CreateBookDto;
import ru.clevertec.client.dto.UpdateBookDto;
import ru.clevertec.client.models.Book;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BookMapper {

    BookDto convertToDto(Book book);
    List<BookDto> convertAllToDtos(Iterable<Book> books);
    void updateBook(UpdateBookDto dto, @MappingTarget Book book);
    Book convertCreateDtoToBook(CreateBookDto dto);
}
