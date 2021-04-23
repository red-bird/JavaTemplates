package com.redbird.lesson16.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "books")
@NoArgsConstructor
public class Book {

    @Id
    @SequenceGenerator(name = "books_seq", sequenceName = "books_sequence", allocationSize = 1)
    @GeneratedValue(generator = "books_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private ZonedDateTime creationDate;
    @ManyToOne
    @JsonIgnore
    private Author author;

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
        this.creationDate = ZonedDateTime.now();
    }
}
