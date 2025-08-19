package com.neueda.library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.datatype.jsr310.deser.key.OffsetDateTimeKeyDeserializer;
import com.neueda.library.utils.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String publisher;
    private Genre genre;
    @Enumerated(EnumType.STRING)
    @Column(name = "bookStatus")
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
