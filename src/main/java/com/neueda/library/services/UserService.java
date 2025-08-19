package com.neueda.library.services;

import com.neueda.library.entity.BorrowBook;
import com.neueda.library.entity.User;
import com.neueda.library.exceptions.InvalidUserException;
import com.neueda.library.exceptions.NoExistingUser;
import com.neueda.library.repositories.BookRepository;
import com.neueda.library.repositories.BorrowBookRepository;
import com.neueda.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    private final UserRepository userRepository;
    private final BorrowBookRepository borrowBookRepository;
    private final BorrowBookService borrowBookService;
    private final BookRepository bookRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       BorrowBookRepository borrowBookRepository,
                       BookRepository bookRepository,
                       BorrowBookService borrowBookService) {
        this.userRepository = userRepository;
        this.borrowBookRepository = borrowBookRepository;
        this.borrowBookService = borrowBookService;
        this.bookRepository = bookRepository;
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
        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new InvalidUserException("Password must be at least 6 characters long");
        }
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new InvalidUserException("User with id " + id + " not found"));
    }

    public BorrowBook borrowBook(Long userId, Long bookId) {
        return borrowBookService.borrowBook(userId, bookId);
    }

    public void deleteUser(Long id) {
            if (!userRepository.existsById(id)) {
                throw new NoExistingUser("User with id " + id + " not found");
            }
            userRepository.deleteById(id);
    }
    public void modifiedFields(User modifiedUser, User newUser) {
        if (newUser.getName() != null) {
            modifiedUser.setName(newUser.getName());
        }
        if (newUser.getEmail() != null) {
            modifiedUser.setEmail(newUser.getEmail());
        }
    }
    public void updateUser(Long userId, User newUser) {
        var userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            var modifiedUser = userOptional.get();
            modifiedFields(modifiedUser, newUser);
            userRepository.save(modifiedUser);
        } else {
            throw new NoExistingUser("User with id " + userId + " not found");
        }
    }
}

