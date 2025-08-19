package com.neueda.library.services;

import com.neueda.library.controllers.UserController;
import com.neueda.library.entity.Book;
import com.neueda.library.entity.BorrowBook;
import com.neueda.library.entity.User;
import com.neueda.library.exceptions.InvalidUserException;
import com.neueda.library.repositories.BookRepository;
import com.neueda.library.repositories.BorrowBookRepository;
import com.neueda.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    private final UserRepository userRepository;
    private final BorrowBookRepository borrowBookRepository;
    private final BookRepository bookRepository;
    private final BorrowBookService borrowBookService;

    @Autowired
    public UserService(UserRepository userRepository,
                       BorrowBookRepository borrowBookRepository,
                       BookRepository bookRepository,
                       BorrowBookService borrowBookService) {
        this.userRepository = userRepository;
        this.borrowBookRepository = borrowBookRepository;
        this.bookRepository = bookRepository;
        this.borrowBookService = borrowBookService;
    }

    public List<BorrowBook> getMyBooks(Long userId) {
        return borrowBookRepository.findByFromUserId_Id(userId);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user) {
        if (user.getName() == null || user.getName().isBlank()) {
            throw new InvalidUserException("Name cannot be empty");
        }
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new InvalidUserException("Invalid email address");
        }
        /*if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new InvalidUserException("Password must be at least 6 characters long");
        }*/
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new InvalidUserException("User with id " + id + " not found"));
    }


    public BorrowBook borrowBook(Long userId, Long bookId) {
        return borrowBookService.borrowBook(userId, bookId);
    }
}

