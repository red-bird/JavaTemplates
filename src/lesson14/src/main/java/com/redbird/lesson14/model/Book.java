package com.redbird.lesson14.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Data
@Component
@NoArgsConstructor
public class Book {

    private String name;
    private ZonedDateTime creationDate;

    public Book(String name) {
        this.name = name;
        this.creationDate = ZonedDateTime.now();
    }
}
