package com.redbird.lesson19.services;

import com.redbird.lesson19.models.Author;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorInterface {
    public List<Author> getAuthors();
    public Author getAuthorById(Long id);
    public List<Author> getAuthorByFirstname(String firstname);
    public List<Author> getAuthorByLastname(String lastname);
    public List<Author> getAuthorByMiddlename(String middlename);
    public List<Author> getAuthorByBirthdate(String birthdate);
    public Author saveOrUpdate(String firstName, String lastName, String middleName, String birthday);
    public void delete(Long id);
}
