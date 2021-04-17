package com.redbird.lesson14.controllers;

import com.redbird.lesson14.model.Author;
import com.redbird.lesson14.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/entities")
public class EntityController {

    List<Book> books = new ArrayList<Book>();
    List<Author> authors = new ArrayList<Author>();

    @GetMapping()
    public String get(Map<String, Object> model) {
        model.put("books", books);
        model.put("authors", authors);
        return "entity";
    }

    @PostMapping("/book")
    public String postBook(@RequestParam String name, Map<String, Object> model) {
        Book book = new Book(name);
        books.add(book);
        model.put("books", books);
        model.put("authors", authors);
        return "redirect:/entities";
    }

    @PostMapping("/book/del")
    public String deleteBook(@RequestParam String name) {
        books.removeIf(book -> book.getName().equals(name));
        return "redirect:/entities";
    }

    @PostMapping("/author")
    public String postAuthor(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String middleName,
            @RequestParam String birthDate,
            Map<String, Object> model) {
        Author author = new Author(firstName, lastName, middleName, birthDate);
        authors.add(author);
        model.put("books", books);
        model.put("authors", authors);
        return "redirect:/entities";
    }

    @PostMapping("/author/del")
    public String deleteAuthor(@RequestParam String firstName) {
        authors.removeIf(author -> author.getFirstName().equals(firstName));
        return "redirect:/entities";
    }
}
