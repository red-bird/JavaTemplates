package com.redbird.lesson24.services;

import com.redbird.lesson24.models.Author;
import com.redbird.lesson24.repositories.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAuthors() {
        log.info("get all authors");
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        log.info("get {} by id {}", author, id);
        return author;
    }

    @Override
    public List<Author> getAuthorByFirstname(String firstname) {
        List<Author> allByFirstName = authorRepository.findAllByFirstName(firstname);
        log.info("get {} by firstname: {}", allByFirstName, firstname);
        return allByFirstName;
    }

    @Override
    public List<Author> getAuthorByLastname(String lastname) {
        List<Author> allByLastName = authorRepository.findAllByLastName(lastname);
        log.info("get {} by lastname: {}", allByLastName, lastname);
        return allByLastName;
    }

    @Override
    public List<Author> getAuthorByMiddlename(String middlename) {
        List<Author> allByMiddleName = authorRepository.findAllByMiddleName(middlename);
        log.info("get {} by middlename: {}", allByMiddleName, middlename);
        return allByMiddleName;
    }

    @Override
    public List<Author> getAuthorByBirthdate(String birthdate) {
        List<Author> allByBirthDate = authorRepository.findAllByBirthDate(birthdate);
        log.info("get {} by birthdate: {}", allByBirthDate, birthdate);
        return allByBirthDate;
    }

    @Override
    public Author saveOrUpdate(String firstName, String lastName, String middleName, String birthday) {
        Author author = new Author(
                firstName,
                lastName,
                middleName,
                birthday
        );
        author = authorRepository.save(author);
        log.info("save author {}", author);
        return author;
    }

    @Override
    public void delete(Long id) {
        Author authorById = getAuthorById(id);
        log.info("delete author: {}", authorById);
        authorRepository.delete(authorById);
    }

}
