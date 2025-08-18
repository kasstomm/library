package com.neueda.library.repositories;


import com.neueda.library.entity.Book;
import com.neueda.library.entity.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBook,Long> {

    List<Book> findAllByUserId(Long userId);

}
