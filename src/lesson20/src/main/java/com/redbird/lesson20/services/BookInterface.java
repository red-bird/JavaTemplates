package com.redbird.lesson20.services;

import com.redbird.lesson20.models.Author;
import com.redbird.lesson20.models.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookInterface {
    public List<Book> getBooks();
    public Author getAuthorByBook(Long id);
    public List<Book> getBookByAuthor(Long authorId);
    public List<Book> getBookByDate(String date);
    public List<Book> getBookByName(String name);
    public Book getBookById(Long id);
    public void delete(Long id);
    public Book saveOrUpdate(String name, Long authorId, String creationDate);
}
