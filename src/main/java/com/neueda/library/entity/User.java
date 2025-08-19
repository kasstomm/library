package com.neueda.library.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

@JsonManagedReference("borrowedBooks")
@OneToMany(cascade = CascadeType.ALL, mappedBy = "fromUserId")
List<BorrowBook> borrowedBooks;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.borrowedBooks = new ArrayList<>();
    }
}
