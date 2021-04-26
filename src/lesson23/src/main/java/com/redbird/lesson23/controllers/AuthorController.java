package com.redbird.lesson23.controllers;

import com.redbird.lesson23.services.AuthorService;
import com.redbird.lesson23.services.AuthorServiceImpl;
import com.redbird.lesson23.services.BookService;
import com.redbird.lesson23.services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/entities/author")
public class AuthorController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public AuthorController(BookServiceImpl bookServiceImpl, AuthorServiceImpl authorServiceImpl) {
        this.bookService = bookServiceImpl;
        this.authorService = authorServiceImpl;
    }

    @GetMapping("/getAuthorById")
    public String getAuthorById(
            @RequestParam String id,
            Map<String, Object> model) {
        model.put("result", authorService.getAuthorById(Long.parseLong(id)));
        model.put("books", bookService.getBooks());
        model.put("authors", authorService.getAuthors());
        return "entity";
    }

    @GetMapping("/getAuthorByFirstname")
    public String getAuthorByFirstname(
            @RequestParam String firstname,
            Map<String, Object> model) {
        model.put("result", authorService.getAuthorByFirstname(firstname));
        model.put("books", bookService.getBooks());
        model.put("authors", authorService.getAuthors());
        return "entity";
    }

    @GetMapping("/getAuthorByMiddlename")
    public String getAuthorByMiddlename(
            @RequestParam String middlename,
            Map<String, Object> model) {
        model.put("result", authorService.getAuthorByMiddlename(middlename));
        model.put("books", bookService.getBooks());
        model.put("authors", authorService.getAuthors());
        return "entity";
    }

    @GetMapping("/getAuthorByLastname")
    public String getAuthorByLastname(
            @RequestParam String lastname,
            Map<String, Object> model) {
        model.put("result", authorService.getAuthorByLastname(lastname));
        model.put("books", bookService.getBooks());
        model.put("authors", authorService.getAuthors());
        return "entity";
    }

    @GetMapping("/getAuthorByBirthdate")
    public String getAuthorByBirthdate(
            @RequestParam String birthdate,
            Map<String, Object> model) {
        model.put("result", authorService.getAuthorByBirthdate(birthdate));
        model.put("books", bookService.getBooks());
        model.put("authors", authorService.getAuthors());
        return "entity";
    }

    @PostMapping()
    public String postAuthor(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String middleName,
            @RequestParam String birthDate,
            Map<String, Object> model) {
        authorService.saveOrUpdate(firstName, lastName, middleName, birthDate);
        model.put("books", bookService.getBooks());
        model.put("authors", authorService.getAuthors());
        return "redirect:/entities";
    }

    @PostMapping("/del")
    public String deleteAuthor(@RequestParam String id) {
        authorService.delete(Long.parseLong(id));
        return "redirect:/entities";
    }

}
