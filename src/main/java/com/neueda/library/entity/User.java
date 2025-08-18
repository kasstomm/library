package com.neueda.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<BorrowBook> books;
    @OneToMany(mappedBy = "user")
    private List<BorrowBook> history;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.books = new ArrayList<>();
        this.history = new ArrayList<>();
    }
}
