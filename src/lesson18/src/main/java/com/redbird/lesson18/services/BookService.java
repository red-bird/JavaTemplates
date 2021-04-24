package com.redbird.lesson18.services;

import com.redbird.lesson18.models.Author;
import com.redbird.lesson18.models.Book;
import com.redbird.lesson18.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookInterface {

//    private final SessionFactory sessionFactory;
//    private Session session;
//    CriteriaBuilder builder;
//
//    @Autowired
//    public BookService(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

//    @PostConstruct
//    void init() {
//        session = sessionFactory.openSession();
//        builder = session.getCriteriaBuilder();
//    }

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
//        CriteriaQuery<Book> bookCriteriaQuery =
//                builder.createQuery(Book.class);
//        Root<Book> root = bookCriteriaQuery.from(Book.class);
//        Query<Book> query = session.createQuery(bookCriteriaQuery);
//        return query.getResultList();
    }

    @Override
    public Author getAuthorByBook(Long id) {
        return getBookById(id).getAuthor();
    }

    @Override
    public List<Book> getBookByAuthor(Long authorId) {
        return bookRepository.findAllByAuthor(authorService.getAuthorById(authorId));
    }

    @Override
    public List<Book> getBookByDate(String date) {
        return bookRepository.findAllByCreationDate(date);
    }

    @Override
    public List<Book> getBookByName(String name) {
        return bookRepository.findAllByName(name);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        bookRepository.delete(getBookById(id));
    }

    @Override
    public Book saveOrUpdate(String name, Long authorId, String creationDate) {
        return bookRepository.save(new Book(
                        name,
                        authorService.getAuthorById(authorId),
                        creationDate)
        );
    }

    //    public Author getAuthorByBook(Long bookId) {
//        CriteriaQuery<Book> bookCriteriaQuery =
//                builder.createQuery(Book.class);
//        Root<Book> root = bookCriteriaQuery.from(Book.class);
//        bookCriteriaQuery.select(root);
//        bookCriteriaQuery.where(builder.equal(root.get("id"), bookId));
//        Query<Book> query = session.createQuery(bookCriteriaQuery);
//        Author author = query.getSingleResult().getAuthor();
//        return author;
//    }
//
//    public List<Book> getBookByAuthor(Long authorId) {
//        CriteriaQuery<Book> bookCriteriaQuery =
//                builder.createQuery(Book.class);
//        Root<Book> root = bookCriteriaQuery.from(Book.class);
//        bookCriteriaQuery.select(root);
//        bookCriteriaQuery.where(builder.equal(root.get("author"), authorId));
//        Query<Book> query = session.createQuery(bookCriteriaQuery);
//        return query.getResultList();
//    }
//
//    public List<Book> getBookByDate(String creationDate) {
//        CriteriaQuery<Book> cq =
//                builder.createQuery(Book.class);
//        Root<Book> root = cq.from(Book.class);
//        cq.select(root);
//        cq.where(builder.equal(root.get("creationDate"), creationDate));
//        Query<Book> query = session.createQuery(cq);
//        return query.getResultList();
//    }
//
//    public List<Book> getBookByName(String name) {
//        CriteriaQuery<Book> bookCriteriaQuery =
//                builder.createQuery(Book.class);
//        Root<Book> root = bookCriteriaQuery.from(Book.class);
//        bookCriteriaQuery.select(root);
//        bookCriteriaQuery.where(builder.equal(root.get("name"), name));
//        Query<Book> query = session.createQuery(bookCriteriaQuery);
//        return query.getResultList();
//    }
//
//    public Book getBookById(Long id) {
//        CriteriaQuery<Book> bookCriteriaQuery =
//                builder.createQuery(Book.class);
//        Root<Book> root = bookCriteriaQuery.from(Book.class);
//        bookCriteriaQuery.select(root);
//        bookCriteriaQuery.where(builder.equal(root.get("id"), id));
//        Query<Book> query = session.createQuery(bookCriteriaQuery);
//        return query.getSingleResult();
//    }
//
//    public void saveOrUpdate(String name, Long authorId, String creationDate) {
//        Author author = session
//                .createQuery("from Author where id = :id", Author.class)
//                .setParameter("id", authorId).getSingleResult();
//        if (author == null) {
//            System.out.println("Author: " + authorId + "is unknown");
//            return;
//        }
//        Book book = new Book(name, author, creationDate);
//        var transaction = session.beginTransaction();
//        session.saveOrUpdate(book);
//        transaction.commit();
//    }
//
//    public void delete(String name) {
//        List<Book> books = session.createQuery(
//                "SELECT b FROM Book b WHERE " +
//                        "name='" +
//                        name
//                        + "'",
//                    Book.class)
//                    .getResultList();
//        books.forEach(book -> {
//            var transaction = session.beginTransaction();
//            session.delete(book);
//            transaction.commit();
//        });
//    }

}
