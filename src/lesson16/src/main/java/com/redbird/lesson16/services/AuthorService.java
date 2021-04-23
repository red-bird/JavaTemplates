package com.redbird.lesson16.services;

import com.redbird.lesson16.models.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AuthorService {

    private final SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public AuthorService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public List<Author> getAuthors() {
        return session.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

    public void saveOrUpdate(String firstName, String lastName, String middleName, String birthday) {
        Author author = new Author(firstName, lastName, middleName, birthday);
        var transaction = session.beginTransaction();
        session.saveOrUpdate(author);
        transaction.commit();

    }

    public void delete(String id) {
        List<Author> authors  = session.createQuery(
                "SELECT a FROM Author a WHERE " +
                        "id='" +
                        id
                        + "'",
                Author.class)
                .getResultList();
        authors.forEach(author -> {
            var transaction = session.beginTransaction();
            session.delete(author);
            transaction.commit();
        });
    }

}
