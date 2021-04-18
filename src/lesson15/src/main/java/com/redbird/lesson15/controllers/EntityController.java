package com.redbird.lesson15.controllers;

import com.redbird.lesson15.models.Author;
import com.redbird.lesson15.models.Book;
import com.redbird.lesson15.services.AuthorService;
import com.redbird.lesson15.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/entities")
public class EntityController {

//    List<Book> books = new ArrayList<Book>();
//    List<Author> authors = new ArrayList<Author>();


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

    @PostMapping("/book")
    public String postBook(@RequestParam String name, Map<String, Object> model) {
        bookService.saveOrUpdate(name);
        model.put("books", bookService.getBooks());
        model.put("authors", authorService.getAuthors());
        return "redirect:/entities";
    }

    @PostMapping("/book/del")
    public String deleteBook(@RequestParam String name) {
        bookService.delete(name);
        return "redirect:/entities";
    }

    @PostMapping("/author")
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

    @PostMapping("/author/del")
    public String deleteAuthor(@RequestParam String id) {
        authorService.delete(id);
        return "redirect:/entities";
    }
}
