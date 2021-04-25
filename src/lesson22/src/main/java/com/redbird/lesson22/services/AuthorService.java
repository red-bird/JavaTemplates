package com.redbird.lesson22.services;

import com.redbird.lesson22.models.Author;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public interface AuthorService {
    public List<Author> getAuthors();
    public Author getAuthorById(Long id);
    public List<Author> getAuthorByFirstname(String firstname);
    public List<Author> getAuthorByLastname(String lastname);
    public List<Author> getAuthorByMiddlename(String middlename);
    public List<Author> getAuthorByBirthdate(String birthdate);
    public Author saveOrUpdate(String firstName, String lastName, String middleName, String birthday);
    public void delete(Long id);
}
