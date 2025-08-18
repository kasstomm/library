package com.neueda.library.services;

import com.neueda.library.entity.Book;
import com.neueda.library.entity.BorrowBook;
import com.neueda.library.exceptions.BookNotFoundException;
import com.neueda.library.exceptions.InvalidBookException;
import com.neueda.library.repositories.BorrowBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowBookService implements IBorrowBookService {

    private final BorrowBookRepository borrowBookRepository;

    public BorrowBookService(BorrowBookRepository borrowBookRepository) {
        this.borrowBookRepository = borrowBookRepository;
    }

    public List<BorrowBook> getAllBorrowedBooks() {
        return borrowBookRepository.findAll();
    }

    public BorrowBook borrowBook(BorrowBook borrowBook) {
        return borrowBookRepository.save(borrowBook);
    }
}
