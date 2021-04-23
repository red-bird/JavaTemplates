package com.redbird.lesson16.services;

import com.redbird.lesson16.models.Author;
import com.redbird.lesson16.models.Book;
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

    public Author getAuthorByBook(Long bookId) {
        return session
                .createQuery("from Book where id = :id", Book.class)
                .setParameter("id", bookId).getSingleResult().getAuthor();
    }
    public void saveOrUpdate(String name, Long authorId) {
        Author author = session
                .createQuery("from Author where id = :id", Author.class)
                .setParameter("id", authorId).getSingleResult();
        if (author == null) {
            System.out.println("Author: " + authorId + "is unknown");
            return;
        }
        Book book = new Book(name, author);
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
