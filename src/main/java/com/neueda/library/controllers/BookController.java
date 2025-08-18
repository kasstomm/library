package com.neueda.library.controllers;

import com.neueda.library.entity.Book;
import com.neueda.library.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    public BookController(BookService bookService) {this.bookService = bookService;}

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        logger.info("GET /books called");
        List<Book> books = bookService.getAllBooks();
        for (Book book : books) {
            logger.info("Book details: {}", book);
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        logger.info("GET /books/{} called", id);
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }


    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        logger.info("POST /books called with book: {}", book);
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.ok(createdBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        logger.info("DELETE /books/{} called", id);
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
