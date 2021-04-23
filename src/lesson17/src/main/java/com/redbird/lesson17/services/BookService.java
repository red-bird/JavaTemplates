package com.redbird.lesson17.services;

import com.redbird.lesson17.models.Author;
import com.redbird.lesson17.models.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class BookService {

    private final SessionFactory sessionFactory;
    private Session session;
    CriteriaBuilder builder;

    @Autowired
    public BookService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
    }

    public List<Book> getBooks() {
        CriteriaQuery<Book> bookCriteriaQuery =
                builder.createQuery(Book.class);
        Root<Book> root = bookCriteriaQuery.from(Book.class);
        Query<Book> query = session.createQuery(bookCriteriaQuery);
        return query.getResultList();
    }

    public Author getAuthorByBook(Long bookId) {
        CriteriaQuery<Book> bookCriteriaQuery =
                builder.createQuery(Book.class);
        Root<Book> root = bookCriteriaQuery.from(Book.class);
        bookCriteriaQuery.select(root);
        bookCriteriaQuery.where(builder.equal(root.get("id"), bookId));
        Query<Book> query = session.createQuery(bookCriteriaQuery);
        Author author = query.getSingleResult().getAuthor();
        return author;
    }

    public List<Book> getBookByAuthor(Long authorId) {
        CriteriaQuery<Book> bookCriteriaQuery =
                builder.createQuery(Book.class);
        Root<Book> root = bookCriteriaQuery.from(Book.class);
        bookCriteriaQuery.select(root);
        bookCriteriaQuery.where(builder.equal(root.get("author"), authorId));
        Query<Book> query = session.createQuery(bookCriteriaQuery);
        return query.getResultList();
    }

    public List<Book> getBookByDate(String creationDate) {
        CriteriaQuery<Book> cq =
                builder.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root);
        cq.where(builder.equal(root.get("creationDate"), creationDate));
        Query<Book> query = session.createQuery(cq);
        return query.getResultList();
    }

    public List<Book> getBookByName(String name) {
        CriteriaQuery<Book> bookCriteriaQuery =
                builder.createQuery(Book.class);
        Root<Book> root = bookCriteriaQuery.from(Book.class);
        bookCriteriaQuery.select(root);
        bookCriteriaQuery.where(builder.equal(root.get("name"), name));
        Query<Book> query = session.createQuery(bookCriteriaQuery);
        return query.getResultList();
    }

    public Book getBookById(Long id) {
        CriteriaQuery<Book> bookCriteriaQuery =
                builder.createQuery(Book.class);
        Root<Book> root = bookCriteriaQuery.from(Book.class);
        bookCriteriaQuery.select(root);
        bookCriteriaQuery.where(builder.equal(root.get("id"), id));
        Query<Book> query = session.createQuery(bookCriteriaQuery);
        return query.getSingleResult();
    }

    public void saveOrUpdate(String name, Long authorId, String creationDate) {
        Author author = session
                .createQuery("from Author where id = :id", Author.class)
                .setParameter("id", authorId).getSingleResult();
        if (author == null) {
            System.out.println("Author: " + authorId + "is unknown");
            return;
        }
        Book book = new Book(name, author, creationDate);
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
