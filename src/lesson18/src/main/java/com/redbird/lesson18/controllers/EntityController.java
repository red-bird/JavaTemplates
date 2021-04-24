package com.redbird.lesson18.controllers;

import com.redbird.lesson18.services.AuthorService;
import com.redbird.lesson18.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/entities")
public class EntityController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public EntityController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping()
    public String get(Map<String, Object> model) {
        model.put("books", bookService.getBooks());
        model.put("authors", authorService.getAuthors());
        return "entity";
    }

}
