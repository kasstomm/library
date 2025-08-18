package com.neueda.library.controllers;

import com.neueda.library.entity.Book;
import com.neueda.library.entity.BorrowBook;
import com.neueda.library.repositories.BorrowBookRepository;
import com.neueda.library.services.BorrowBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowedBooks")
public class BorrowBookControler {

    private final BorrowBookService borrowBookService;
    private final Logger logger = LoggerFactory.getLogger(BorrowBookControler.class);

    @Autowired
    public BorrowBookControler(BorrowBookService borrowBookService) {
        this.borrowBookService = borrowBookService;
    }

    @GetMapping
    public ResponseEntity<List<BorrowBook>> getBooks() {
        logger.info("GET /borrowedBooks called");
        List<BorrowBook> borrowBooks = borrowBookService.getAllBorrowedBooks();
        for (BorrowBook borrowBook : borrowBooks) {
            logger.info("Borrowed book details: {}", borrowBook);
        }
        return ResponseEntity.ok(borrowBooks);
    }

    @PostMapping
    public ResponseEntity<BorrowBook> createBook(@RequestBody BorrowBook borrowBook) {
        logger.info("POST /borrowedBooks called with book: {}", borrowBook);
        BorrowBook borrowedBook = borrowBookService.borrowBook(borrowBook);
        return ResponseEntity.ok(borrowedBook);
    }
}
