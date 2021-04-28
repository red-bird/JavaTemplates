package com.redbird.lesson24.services;

import com.redbird.lesson24.models.Author;
import com.redbird.lesson24.models.Book;
import com.redbird.lesson24.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public List<Book> getBooks() {
        log.info("get all books");
        return bookRepository.findAll();
    }

    @Override
    public Author getAuthorByBook(Long id) {
        Author author = getBookById(id).getAuthor();
        log.info("get {} by  bookId {}", author, id);
        return author;
    }

    @Override
    public List<Book> getBookByAuthor(Long authorId) {
        List<Book> allByAuthor = bookRepository.findAllByAuthor(authorService.getAuthorById(authorId));
        log.info("get {} by author: {}", allByAuthor, authorId);
        return allByAuthor;
    }

    @Override
    public List<Book> getBookByDate(String date) {
        List<Book> allByCreationDate = bookRepository.findAllByCreationDate(date);
        log.info("get {} by creation date: {}", allByCreationDate, date);
        return allByCreationDate;
    }

    @Override
    public List<Book> getBookByName(String name) {
        List<Book> allByName = bookRepository.findAllByName(name);
        log.info("get {} by name: {}", allByName, name);
        return allByName;
    }

    @Override
    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        log.info("get {} by id: {}", book, id);
        return book;
    }

    @Override
    public void delete(Long id) {
        Book bookById = getBookById(id);
        log.info("delete book: {}", bookById);
        bookRepository.delete(bookById);
    }

    @Override
    public Book saveOrUpdate(String name, Long authorId, String creationDate) {
        Book book = new Book(
                name,
                authorService.getAuthorById(authorId),
                creationDate);
        book = bookRepository.save(book);
        log.info("Save book {}", book);
        return book;
    }

}
