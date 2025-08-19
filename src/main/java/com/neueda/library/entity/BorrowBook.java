package com.neueda.library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "borrowedBooksHistory")
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonBackReference("borrowedBooks")
    @ManyToOne
    private User fromUserId;
    @ManyToOne
    @JsonManagedReference("borrowHistory")
    private Book fromBookId;

    private LocalDateTime  returnDate;
    private LocalDateTime   borrowDate;

    public BorrowBook(User fromUserId, Book fromBookId) {
        this.fromUserId = fromUserId;
        this.fromBookId = fromBookId;
        this.returnDate = null;
        this.borrowDate = LocalDateTime.now();
    }
}