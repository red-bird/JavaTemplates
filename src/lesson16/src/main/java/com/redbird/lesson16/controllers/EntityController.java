package com.redbird.lesson16.controllers;

import com.redbird.lesson16.models.Author;
import com.redbird.lesson16.services.AuthorService;
import com.redbird.lesson16.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/book/getAuthor")
    public @ResponseBody Author getAuthorByBookId(
            @RequestParam String bookId,
            Map<String, Object> model) {
//        model.put("result", bookService.getAuthorByBook(Long.parseLong(bookId)));
//        model.put("books", bookService.getBooks());
//        model.put("authors", authorService.getAuthors());
//        return "entity";
        return bookService.getAuthorByBook(Long.parseLong(bookId));
    }

    @PostMapping("/book")
    public String postBook(
            @RequestParam String name,
            @RequestParam String authorId,
            Map<String, Object> model) {
        bookService.saveOrUpdate(name, Long.parseLong(authorId));
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
