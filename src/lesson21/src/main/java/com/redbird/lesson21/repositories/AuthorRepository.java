package com.redbird.lesson21.repositories;

import com.redbird.lesson21.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByFirstName(String firstname);
    List<Author> findAllByLastName(String lastname);
    List<Author> findAllByMiddleName(String middlename);
    List<Author> findAllByBirthDate(String birthdate);
}
