package com.redbird.lesson19.repositories;

import com.redbird.lesson19.models.Author;
import com.redbird.lesson19.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthor(Author author);
    List<Book> findAllByCreationDate(String date);
    List<Book> findAllByName(String name);
}
