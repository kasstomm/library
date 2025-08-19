package com.neueda.library.services;

import com.neueda.library.entity.Book;
import com.neueda.library.entity.BorrowBook;
import com.neueda.library.entity.User;
import com.neueda.library.repositories.BookRepository;
import com.neueda.library.repositories.BorrowBookRepository;
import com.neueda.library.repositories.UserRepository;
import com.neueda.library.utils.BookStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BorrowBookService {

    private final BorrowBookRepository borrowBookRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BorrowBookService(BorrowBookRepository borrowBookRepository,
                             UserRepository userRepository,
                             BookRepository bookRepository) {
        this.borrowBookRepository = borrowBookRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public BorrowBook borrowBook(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getBookStatus() != BookStatus.AVAILABLE) {
            throw new RuntimeException("Book is not available");
        }

        BorrowBook borrow = new BorrowBook(user, book);
        book.setBookStatus(BookStatus.LENT);

        bookRepository.save(book);
        return borrowBookRepository.save(borrow);
    }

    public BorrowBook returnBook(Long borrowId) {
        BorrowBook borrow = borrowBookRepository.findById(borrowId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        borrow.setReturnDate(LocalDateTime.now());
        Book book = borrow.getFromBookId();
        book.setBookStatus(BookStatus.AVAILABLE);

        bookRepository.save(book);
        return borrowBookRepository.save(borrow);
    }

    public List<BorrowBook> getBorrowHistoryForUser(Long userId) {
        return borrowBookRepository.findByFromUserId_Id(userId);
    }

    public List<BorrowBook> getBorrowHistoryForBook(Long bookId) {
        return borrowBookRepository.findByFromBookId_Id(bookId);
    }
}
