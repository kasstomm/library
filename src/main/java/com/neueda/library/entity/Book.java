package com.neueda.library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.neueda.library.utils.BookStatus;
import com.neueda.library.utils.Genre;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "books")
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String publisher;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    @Column(name = "bookStatus", nullable = false)
    private BookStatus bookStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromBookId")
    @JsonManagedReference("borrowHistory")
    List<BorrowBook> borrowHistory;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.bookStatus = BookStatus.AVAILABLE;
        this.borrowHistory = new ArrayList<>();
    }
}
