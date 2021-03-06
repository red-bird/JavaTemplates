package com.redbird.lesson20.controllers;

import com.redbird.lesson20.services.AuthorInterface;
import com.redbird.lesson20.services.AuthorService;
import com.redbird.lesson20.services.BookInterface;
import com.redbird.lesson20.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/entities/book")
public class BookController {

    private final BookInterface bookService;
    private final AuthorInterface authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/getAuthor")
    public String getAuthorByBookId(
            @RequestParam String bookId,
            Map<String, Object> model) {
        model.put("result", bookService.getAuthorByBook(Long.parseLong(bookId)));
        model.put("books", bookService.getBooks());
        model.put("authors", authorService.getAuthors());
        return "entity";
//        return bookService.getAuthorByBook(Long.parseLong(bookId));
    }

    @GetMapping("/getByAuthorId")
    public String getByAuthor(
            @RequestParam String authorId,
            Map<String, Object> model) {
        model.put("result", bookService.getBookByAuthor(Long.parseLong(authorId)));
        model.put("books", bookService.getBooks());
        model.put("authors", authorService.getAuthors());
        return "entity";
    }

    @GetMapping("/getByDate")
    public String getBookByDate(
            @RequestParam String date,
            Map<String, Object> model) {
        model.put("result", bookService.getBookByDate(date));
        model.put("books", bookService.getBooks());
        model.put("authors", authorService.getAuthors());
        return "entity";
    }

    @GetMapping("/getByName")
    public String getBookByName(
            @RequestParam String name,
            Map<String, Object> model) {
        model.put("result", bookService.getBookByName(name));
        model.put("books", bookService.getBooks());
        model.put("authors", authorService.getAuthors());
        return "entity";
    }

    @GetMapping("/getById")
    public String getBookById(
            @RequestParam String id,
            Map<String, Object> model) {
        model.put("result", bookService.getBookById(Long.parseLong(id)));
        model.put("books", bookService.getBooks());
        model.put("authors", authorService.getAuthors());
        return "entity";
    }

    @PostMapping()
    public String postBook(
            @RequestParam String name,
            @RequestParam String authorId,
            @RequestParam String creationDate,
            Map<String, Object> model) {
        bookService.saveOrUpdate(name, Long.parseLong(authorId), creationDate);
        model.put("books", bookService.getBooks());
        model.put("authors", authorService.getAuthors());
        return "redirect:/entities";
    }

    @PostMapping("/del")
    public String deleteBook(@RequestParam String id) {
        bookService.delete(Long.parseLong(id));
        return "redirect:/entities";
    }

}
