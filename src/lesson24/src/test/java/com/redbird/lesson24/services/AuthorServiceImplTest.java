package com.redbird.lesson24.services;

import com.redbird.lesson24.models.Author;
import com.redbird.lesson24.models.User;
import com.redbird.lesson24.repositories.AuthorRepository;
import org.junit.jupiter.api.BeforeAll;
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
class AuthorServiceImplTest {

    @Mock
    private AuthorRepository authorRepository;

    @Captor
    ArgumentCaptor<Author> captor;

    private final String fname1 = "Alan";
    private final String lname1 = "Wake";
    private final String mname1 = "Olegovich";
    private final String bdate1 = "31.02.1985";
    private final String fname2 = "William";
    private final String lname2 = "Shakespeare";

    @Test
    void getAuthors() {
        Author author1 = new Author();
        author1.setFirstName(fname1);
        author1.setLastName(lname1);
        Author author2 = new Author();
        author2.setFirstName(fname2);
        author2.setLastName(lname2);

        Mockito.when(authorRepository.findAll()).thenReturn(List.of(author1, author2));
        AuthorService authorService = new AuthorServiceImpl(authorRepository);
        assertEquals(2, authorService.getAuthors().size());
        assertEquals(fname1, authorService.getAuthors().get(0).getFirstName());
    }

    @Test
    void getAuthorById() {
        Author author = new Author();
        author.setFirstName(fname1);
        author.setLastName(lname2);
        Mockito.when(authorRepository.findById(1L)).thenReturn(java.util.Optional.of(author));
        AuthorService authorService = new AuthorServiceImpl(authorRepository);
        assertEquals(fname1, authorService.getAuthorById(1L).getFirstName());
    }

    @Test
    void getAuthorByFirstname() {
        Author author = new Author();
        author.setFirstName(fname1);
        author.setLastName(lname1);
        Mockito.when(authorRepository.findAllByFirstName(fname1)).thenReturn(List.of(author));
        AuthorService authorService = new AuthorServiceImpl(authorRepository);
        assertEquals(fname1, authorService.getAuthorByFirstname(fname1).get(0).getFirstName());
    }

    @Test
    void getAuthorByLastname() {
        Author author = new Author();
        author.setFirstName(fname1);
        author.setLastName(lname1);
        Mockito.when(authorRepository.findAllByLastName(lname1)).thenReturn(List.of(author));
        AuthorService authorService = new AuthorServiceImpl(authorRepository);
        assertEquals(lname1, authorService.getAuthorByLastname(lname1).get(0).getLastName());
    }

    @Test
    void getAuthorByMiddlename() {
        Author author = new Author();
        author.setFirstName(fname1);
        author.setLastName(lname1);
        author.setMiddleName(mname1);
        Mockito.when(authorRepository.findAllByMiddleName(mname1)).thenReturn(List.of(author));
        AuthorService authorService = new AuthorServiceImpl(authorRepository);
        assertEquals(mname1, authorService.getAuthorByMiddlename(mname1).get(0).getMiddleName());
    }

    @Test
    void getAuthorByBirthdate() {
        Author author = new Author();
        author.setFirstName(fname1);
        author.setLastName(lname1);
        author.setMiddleName(mname1);
        author.setBirthDate(bdate1);
        Mockito.when(authorRepository.findAllByBirthDate(bdate1)).thenReturn(List.of(author));
        AuthorService authorService = new AuthorServiceImpl(authorRepository);
        assertEquals(bdate1, authorService.getAuthorByBirthdate(bdate1).get(0).getBirthDate());
    }

    @Test
    void saveOrUpdate() {
        Author author = new Author();
        author.setFirstName(fname1);
        author.setLastName(lname1);
        author.setMiddleName(mname1);
        author.setBirthDate(bdate1);

        Mockito.when(authorRepository.save(author)).thenReturn(author);
        AuthorService authorService = new AuthorServiceImpl(authorRepository);
        assertEquals(author, authorService.saveOrUpdate(fname1, lname1, mname1, bdate1));

        Mockito.verify(authorRepository).save(captor.capture());
        Author captured = captor.getValue();
        assertEquals(fname1, captured.getFirstName());
        assertEquals(author, captured);
    }

    @Test
    void delete() {
        // can't test because return void, makes no sense
    }
}