package com.neueda.library.entity;

import com.neueda.library.utils.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "book")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String author;
    private String publisher;
    private Genre genre;
    @OneToMany(mappedBy = "book")
    private List<BorrowBook> borrowBook;

    public Book () {}

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

}
