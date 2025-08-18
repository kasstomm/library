package com.neueda.library.services;

import com.neueda.library.controllers.UserController;
import com.neueda.library.entity.Book;
import com.neueda.library.entity.BorrowBook;
import com.neueda.library.entity.User;
import com.neueda.library.repositories.BookRepository;
import com.neueda.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {
    UserRepository userRepository;
    BookRepository bookRepository;
    UserController userController;

    @Autowired
    public UserService(UserRepository userRepository, BookRepository bookRepository, UserController userController) {
    }

    public List<BorrowBook> getBooks(User userId) {
       User user = userRepository.getUsersById(userId);
       List<Book> borrowedBooks = new ArrayList<>();

        return null;
    }
    public List<User> getUsers(){
       return userRepository.getAllUsers();
    }

    public User createUser (User user){
         return userRepository.createUser(user);
    }
}
