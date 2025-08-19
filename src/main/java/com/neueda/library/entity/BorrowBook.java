package com.neueda.library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
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
    @JsonBackReference("borrowHistory")
    private Book fromBookId;

    private Date returnDate;
    private Date borrowDate;

    public BorrowBook(User fromUserId, Book fromBookId) {
        this.fromUserId = fromUserId;
        this.fromBookId = fromBookId;
    }
}