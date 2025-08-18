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
   private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository1) {
        this.userRepository = userRepository1;
    }

//    public List<BorrowBook> getBooks(User userId) {
//
//      return userRepository.findAllById(var);
//
//    }

    public List<User> getUsers(){
       return userRepository.findAll();
    }

    public User createUser (User user){
         return userRepository.save(user);
    }
}
