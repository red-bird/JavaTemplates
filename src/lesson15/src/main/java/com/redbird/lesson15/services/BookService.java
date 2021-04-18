package com.redbird.lesson15.services;

import com.redbird.lesson15.models.Book;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BookService {

    private final SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public BookService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public List<Book> getBooks() {
        return session.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    public void saveOrUpdate(String name) {
        Book book = new Book(name);
        var transaction = session.beginTransaction();
        session.saveOrUpdate(book);
        transaction.commit();

    }

    public void delete(String name) {
        List<Book> books = session.createQuery(
                "SELECT b FROM Book b WHERE " +
                        "name='" +
                        name
                        + "'",
                    Book.class)
                    .getResultList();
        books.forEach(book -> {
            var transaction = session.beginTransaction();
            session.delete(book);
            transaction.commit();
        });
    }

}
