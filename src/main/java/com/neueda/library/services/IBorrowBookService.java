package com.neueda.library.services;

import com.neueda.library.entity.Book;
import com.neueda.library.entity.BorrowBook;

import java.util.List;

public interface IBorrowBookService {
    List<BorrowBook> getAllBorrowedBooks();
    BorrowBook borrowBook(BorrowBook borrowBook);
}
