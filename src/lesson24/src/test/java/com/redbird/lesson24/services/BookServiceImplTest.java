package com.redbird.lesson24.services;

import com.redbird.lesson24.models.Author;
import com.redbird.lesson24.models.Book;
import com.redbird.lesson24.repositories.AuthorRepository;
import com.redbird.lesson24.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorService authorService;

    @Captor
    ArgumentCaptor<Book> captor;

    private final Long author_id = 1L;
    private final String author_fname = "Alan";
    private final String author_lname = "Wake";
    private final String author_mname = "Olegovich";
    private final String author_bdate1 = "31.02.1985";
    private final Long bookId1 = 1L;
    private final String bookName1 = "1984";
    private final String bookDate1 = "1949";
    private final String bookName2 = "Harry Potter";
    private final String bookDate2 = "1997";
    private final Long bookId2 = 2L;

    @Test
    void getBooks() {
        Author author = new Author();
        author.setBirthDate(author_bdate1);
        author.setFirstName(author_fname);
        author.setLastName(author_lname);
        author.setMiddleName(author_mname);
        author.setId(author_id);

        Book book1 = new Book();
        book1.setName(bookName1);
        book1.setCreationDate(bookDate1);
        book1.setAuthor(author);
        Book book2 = new Book();
        book2.setName(bookName2);
        book2.setCreationDate(bookDate2);
        book2.setAuthor(author);

        Mockito.when(bookRepository.findAll()).thenReturn(List.of(book1, book2));
        BookService bookService = new BookServiceImpl(bookRepository, authorService);
        assertEquals(2, bookService.getBooks().size());
        assertEquals(bookName1, bookService.getBooks().get(0).getName());
    }

    @Test
    void getAuthorByBook() {
        Author author = new Author();
        author.setBirthDate(author_bdate1);
        author.setFirstName(author_fname);
        author.setLastName(author_lname);
        author.setMiddleName(author_mname);
        author.setId(author_id);

        Book book1 = new Book();
        book1.setId(bookId1);
        book1.setName(bookName1);
        book1.setCreationDate(bookDate1);
        book1.setAuthor(author);
        Book book2 = new Book();
        book2.setId(bookId2);
        book2.setName(bookName2);
        book2.setCreationDate(bookDate2);
        book2.setAuthor(author);

        Mockito.when(bookRepository.findById(bookId1)).thenReturn(java.util.Optional.of(book1));
        BookService bookService = new BookServiceImpl(bookRepository, authorService);
        assertEquals(author, bookService.getAuthorByBook(bookId1));
    }

    @Test
    void getBookByAuthor() {
        Author author = new Author();
        author.setBirthDate(author_bdate1);
        author.setFirstName(author_fname);
        author.setLastName(author_lname);
        author.setMiddleName(author_mname);
        author.setId(author_id);

        Book book1 = new Book();
        book1.setId(bookId1);
        book1.setName(bookName1);
        book1.setCreationDate(bookDate1);
        book1.setAuthor(author);
        Book book2 = new Book();
        book2.setId(bookId2);
        book2.setName(bookName2);
        book2.setCreationDate(bookDate2);
        book2.setAuthor(author);

        Mockito.when(authorService.getAuthorById(author_id)).thenReturn(author);
        Mockito.when(bookRepository.findAllByAuthor(author)).thenReturn(List.of(book1, book2));
        BookService bookService = new BookServiceImpl(bookRepository, authorService);
        assertEquals(List.of(book1, book2), bookService.getBookByAuthor(author_id));
    }

    @Test
    void getBookByDate() {
        Author author = new Author();
        author.setBirthDate(author_bdate1);
        author.setFirstName(author_fname);
        author.setLastName(author_lname);
        author.setMiddleName(author_mname);
        author.setId(author_id);

        Book book1 = new Book();
        book1.setId(bookId1);
        book1.setName(bookName1);
        book1.setCreationDate(bookDate1);
        book1.setAuthor(author);
        Book book2 = new Book();
        book2.setId(bookId2);
        book2.setName(bookName2);
        book2.setCreationDate(bookDate2);
        book2.setAuthor(author);

        Mockito.when(bookRepository.findAllByCreationDate(bookDate1)).thenReturn(List.of(book1));
        BookService bookService = new BookServiceImpl(bookRepository, authorService);
        assertEquals(List.of(book1), bookService.getBookByDate(bookDate1));
    }

    @Test
    void getBookByName() {
        Author author = new Author();
        author.setBirthDate(author_bdate1);
        author.setFirstName(author_fname);
        author.setLastName(author_lname);
        author.setMiddleName(author_mname);
        author.setId(author_id);

        Book book1 = new Book();
        book1.setId(bookId1);
        book1.setName(bookName1);
        book1.setCreationDate(bookDate1);
        book1.setAuthor(author);
        Book book2 = new Book();
        book2.setId(bookId2);
        book2.setName(bookName2);
        book2.setCreationDate(bookDate2);
        book2.setAuthor(author);

        Mockito.when(bookRepository.findAllByName(bookName1)).thenReturn(List.of(book1));
        BookService bookService = new BookServiceImpl(bookRepository, authorService);
        assertEquals(List.of(book1), bookService.getBookByName(bookName1));
    }

    @Test
    void getBookById() {
        Author author = new Author();
        author.setBirthDate(author_bdate1);
        author.setFirstName(author_fname);
        author.setLastName(author_lname);
        author.setMiddleName(author_mname);
        author.setId(author_id);

        Book book1 = new Book();
        book1.setId(bookId1);
        book1.setName(bookName1);
        book1.setCreationDate(bookDate1);
        book1.setAuthor(author);
        Book book2 = new Book();
        book2.setId(bookId2);
        book2.setName(bookName2);
        book2.setCreationDate(bookDate2);
        book2.setAuthor(author);

        Mockito.when(bookRepository.findById(bookId1)).thenReturn(java.util.Optional.of(book1));
        BookService bookService = new BookServiceImpl(bookRepository, authorService);
        assertEquals(book1, bookService.getBookById(bookId1));
    }

    @Test
    void delete() {
        // can't test because return void, makes no sense
    }

    @Test
    void saveOrUpdate() {
        Author author = new Author();
        author.setBirthDate(author_bdate1);
        author.setFirstName(author_fname);
        author.setLastName(author_lname);
        author.setMiddleName(author_mname);
        author.setId(author_id);

        Book book = new Book();
        book.setName(bookName1);
        book.setCreationDate(bookDate1);
        book.setAuthor(author);

        Mockito.when(bookRepository.save(book)).thenReturn(book);
        Mockito.when(authorService.getAuthorById(book.getAuthor().getId())).thenReturn(author);
        BookService bookService = new BookServiceImpl(bookRepository, authorService);
        assertEquals(book, bookService.saveOrUpdate(bookName1, author.getId(), bookDate1));

        Mockito.verify(bookRepository).save(captor.capture());
        Book captured = captor.getValue();
        assertEquals(bookName1, captured.getName());
        assertEquals(book, captured);
    }
}