package com.redbird.lesson15.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

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

    public Book(String name) {
        this.name = name;
        this.creationDate = ZonedDateTime.now();
    }
}
