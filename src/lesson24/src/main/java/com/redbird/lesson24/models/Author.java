package com.redbird.lesson24.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authors")
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "authors_seq", sequenceName = "authors_sequence", allocationSize = 1)
//    @GeneratedValue(generator = "authors_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
//    @OneToMany(mappedBy = "author")
//    private List<Book> books;

    public Author(String firstName, String lastName, String middleName, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
    }
}
