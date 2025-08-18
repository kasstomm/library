package com.neueda.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    @OneToMany
    private List<BorrowBook> books;
    @OneToMany
    private List<BorrowBook> history;
}
