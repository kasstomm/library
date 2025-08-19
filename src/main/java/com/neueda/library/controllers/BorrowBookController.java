package com.neueda.library.controllers;

import java.util.List;
import com.neueda.library.entity.BorrowBook;
import com.neueda.library.services.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrows")
public class BorrowBookController {

    private final BorrowBookService borrowBookService;

    @Autowired
    public BorrowBookController(BorrowBookService borrowBookService) {
        this.borrowBookService = borrowBookService;
    }

    @PostMapping("/borrow")
    public ResponseEntity<BorrowBook> borrowBook(
            @RequestParam Long userId,
            @RequestParam Long bookId) {
        BorrowBook borrow = borrowBookService.borrowBook(userId, bookId);
        return new ResponseEntity<>(borrow, HttpStatus.CREATED);
    }

    @PutMapping("/{borrowId}/return")
    public ResponseEntity<BorrowBook> returnBook(@PathVariable Long borrowId) {
        BorrowBook borrow = borrowBookService.returnBook(borrowId);
        return ResponseEntity.ok(borrow);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BorrowBook>> getUserHistory(@PathVariable Long userId) {
        List<BorrowBook> history = borrowBookService.getBorrowHistoryForUser(userId);
        return ResponseEntity.ok(history);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<BorrowBook>> getBookHistory(@PathVariable Long bookId) {
        List<BorrowBook> history = borrowBookService.getBorrowHistoryForBook(bookId);
        return ResponseEntity.ok(history);
    }
}

