package com.redbird.lesson24.controllers;

import com.redbird.lesson24.services.AuthorServiceImpl;
import com.redbird.lesson24.services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/entities")
public class EntityController {

    private final BookServiceImpl bookServiceImpl;
    private final AuthorServiceImpl authorServiceImpl;

    @Autowired
    public EntityController(BookServiceImpl bookServiceImpl, AuthorServiceImpl authorServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
        this.authorServiceImpl = authorServiceImpl;
    }

    @GetMapping()
    public String get(Map<String, Object> model) {
        model.put("books", bookServiceImpl.getBooks());
        model.put("authors", authorServiceImpl.getAuthors());
        return "entity";
    }

}
