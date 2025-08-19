package com.neueda.library.controllers;

import com.neueda.library.entity.BorrowBook;
import com.neueda.library.entity.User;
import com.neueda.library.services.BorrowBookService;
import com.neueda.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private  final BorrowBookService borrowBookService;

    @Autowired
    public UserController(UserService userService,  BorrowBookService borrowBookService) {
        this.userService = userService;
        this.borrowBookService = borrowBookService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> allUsers = userService.getUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
    @PostMapping("/{userId}/borrow/{bookId}")
    public ResponseEntity<BorrowBook> borrowBook(
            @PathVariable Long userId,
            @PathVariable Long bookId) {
        BorrowBook borrow = borrowBookService.borrowBook(userId, bookId);
        return new ResponseEntity<>(borrow, HttpStatus.CREATED);
    }

    // zwrot książki przez użytkownika
    @PutMapping("/{userId}/return/{borrowId}")
    public ResponseEntity<BorrowBook> returnBook(
            @PathVariable Long userId,
            @PathVariable Long borrowId) {
        BorrowBook borrow = borrowBookService.returnBook(borrowId);
        return ResponseEntity.ok(borrow);
    }
    // aktualnie wypożyczone książki użytkownika
    @GetMapping("/{userId}/borrowed")
    public ResponseEntity<List<BorrowBook>> getUserBorrowedBooks(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getMyBooks(userId));
    }
    // cała historia wypożyczeń użytkownika
    @GetMapping("/{userId}/history")
    public ResponseEntity<List<BorrowBook>> getUserBorrowHistory(@PathVariable Long userId) {
        return ResponseEntity.ok(borrowBookService.getBorrowHistoryForUser(userId));
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User user) {
        userService.updateUser(userId, user);
        return ResponseEntity.ok("User successfully updated!");
    }
}