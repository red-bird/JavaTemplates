package com.redbird.lesson24.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "books_seq", sequenceName = "books_sequence", allocationSize = 1)
//    @GeneratedValue(generator = "books_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String creationDate;
    @ManyToOne
    @JsonIgnore
    private Author author;

    public Book(String name, Author author, String creationDate) {
        this.name = name;
        this.author = author;
        this.creationDate = creationDate;
    }
}
