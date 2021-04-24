package com.redbird.lesson18.services;

import com.redbird.lesson18.models.Author;
import com.redbird.lesson18.repositories.AuthorRepository;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class AuthorService implements AuthorInterface {

//    private final SessionFactory sessionFactory;
//    private Session session;
//    CriteriaBuilder builder;
//
//    @Autowired
//    public AuthorService(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @PostConstruct
//    void init() {
//        session = sessionFactory.openSession();
//        builder = session.getCriteriaBuilder();
//    }

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Author> getAuthorByFirstname(String firstname) {
        return authorRepository.findAllByFirstName(firstname);
    }

    @Override
    public List<Author> getAuthorByLastname(String lastname) {
        return authorRepository.findAllByLastName(lastname);
    }

    @Override
    public List<Author> getAuthorByMiddlename(String middlename) {
        return authorRepository.findAllByMiddleName(middlename);
    }

    @Override
    public List<Author> getAuthorByBirthdate(String birthdate) {
        return authorRepository.findAllByBirthDate(birthdate);
    }

    @Override
    public Author saveOrUpdate(String firstName, String lastName, String middleName, String birthday) {
        return authorRepository.save(new Author(
                firstName,
                lastName,
                middleName,
                birthday
        ));
    }

    @Override
    public void delete(Long id) {
        authorRepository.delete(getAuthorById(id));
    }

//    public List<Author> getAuthors() {
//        return session.createQuery("SELECT a FROM Author a", Author.class).getResultList();
//    }
//
//    public Author getAuthorById(Long id) {
//        CriteriaQuery<Author> authorCriteriaQuery =
//                builder.createQuery(Author.class);
//        Root<Author> root = authorCriteriaQuery.from(Author.class);
//        authorCriteriaQuery.select(root);
//        authorCriteriaQuery.where(builder.equal(root.get("id"), id));
//        Query<Author> query = session.createQuery(authorCriteriaQuery);
//        return query.getSingleResult();
//    }
//
//    public List<Author> getAuthorByFirstname(String firstname) {
//        CriteriaQuery<Author> authorCriteriaQuery =
//                builder.createQuery(Author.class);
//        Root<Author> root = authorCriteriaQuery.from(Author.class);
//        authorCriteriaQuery.select(root);
//        authorCriteriaQuery.where(builder.equal(root.get("firstName"), firstname));
//        Query<Author> query = session.createQuery(authorCriteriaQuery);
//        return query.getResultList();
//    }
//
//    public List<Author> getAuthorByLastname(String lastname) {
//        CriteriaQuery<Author> authorCriteriaQuery =
//                builder.createQuery(Author.class);
//        Root<Author> root = authorCriteriaQuery.from(Author.class);
//        authorCriteriaQuery.select(root);
//        authorCriteriaQuery.where(builder.equal(root.get("lastName"), lastname));
//        Query<Author> query = session.createQuery(authorCriteriaQuery);
//        return query.getResultList();
//    }
//
//    public List<Author> getAuthorByMiddlename(String middlename) {
//        CriteriaQuery<Author> authorCriteriaQuery =
//                builder.createQuery(Author.class);
//        Root<Author> root = authorCriteriaQuery.from(Author.class);
//        authorCriteriaQuery.select(root);
//        authorCriteriaQuery.where(builder.equal(root.get("middleName"), middlename));
//        Query<Author> query = session.createQuery(authorCriteriaQuery);
//        return query.getResultList();
//    }
//
//    public List<Author> getAuthorByBirthdate(String birthdate) {
//        CriteriaQuery<Author> authorCriteriaQuery =
//                builder.createQuery(Author.class);
//        Root<Author> root = authorCriteriaQuery.from(Author.class);
//        authorCriteriaQuery.select(root);
//        authorCriteriaQuery.where(builder.equal(root.get("birthDate"), birthdate));
//        Query<Author> query = session.createQuery(authorCriteriaQuery);
//        return query.getResultList();
//    }
//
//    public void saveOrUpdate(String firstName, String lastName, String middleName, String birthday) {
//        Author author = new Author(firstName, lastName, middleName, birthday);
//        var transaction = session.beginTransaction();
//        session.saveOrUpdate(author);
//        transaction.commit();
//
//    }
//
//    public void delete(String id) {
//        List<Author> authors  = session.createQuery(
//                "SELECT a FROM Author a WHERE " +
//                        "id='" +
//                        id
//                        + "'",
//                Author.class)
//                .getResultList();
//        authors.forEach(author -> {
//            var transaction = session.beginTransaction();
//            session.delete(author);
//            transaction.commit();
//        });
//    }

}
