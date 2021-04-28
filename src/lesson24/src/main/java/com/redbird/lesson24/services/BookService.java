package com.redbird.lesson24.services;

import com.redbird.lesson24.models.Author;
import com.redbird.lesson24.models.Book;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public interface BookService {
    public List<Book> getBooks();
    public Author getAuthorByBook(Long id);
    public List<Book> getBookByAuthor(Long authorId);
    public List<Book> getBookByDate(String date);
    public List<Book> getBookByName(String name);
    public Book getBookById(Long id);
    public void delete(Long id);
    public Book saveOrUpdate(String name, Long authorId, String creationDate);
}
