package com.neueda.library.services;

import com.neueda.library.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book createBook(Book book);
    void deleteBook(Long id);
}
