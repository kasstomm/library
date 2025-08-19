package com.neueda.library.controllers;

import com.neueda.library.entity.Book;
import com.neueda.library.entity.BorrowBook;
import com.neueda.library.entity.User;
import com.neueda.library.services.BookService;
import com.neueda.library.services.BorrowBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BorrowBookService borrowBookService;
    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    public BookController(BookService bookService, BorrowBookService borrowBookService) {
        this.bookService = bookService;
        this.borrowBookService = borrowBookService;
    }
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
        Book createdBook = bookService.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{bookId}/history")
    public ResponseEntity<List<BorrowBook>> getBookHistory(@PathVariable Long bookId) {
        return ResponseEntity.ok(borrowBookService.getBorrowHistoryForBook(bookId));
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{bookId}")
    public ResponseEntity<?> updateBook(@PathVariable Long bookId, @RequestBody Book book) {
        bookService.updateBook(bookId, book);
        return ResponseEntity.ok("User successfully updated!");
    }
}
