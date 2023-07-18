package ru.clevertec.client.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.client.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
