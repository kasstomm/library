package com.neueda.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

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
    private List<BorrowBook> borrowHistory = new ArrayList<>();

    @Transient
    public List<BorrowBook> getActiveBorrows() {
        return borrowHistory.stream().filter(b -> b.getReturnDate() == null).toList();
    }

    @Transient
    public List<BorrowBook> getPastBorrows() {
        return borrowHistory.stream().filter(b -> b.getReturnDate() != null).toList();
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.borrowHistory = new ArrayList<>();
    }
}
