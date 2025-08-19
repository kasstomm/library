package com.neueda.library.controllers;

import com.neueda.library.entity.Book;
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



    // dla usera aktualne ksiazki
    // dla usera historia wypozyczen
    // wypozycz ksiazke



}