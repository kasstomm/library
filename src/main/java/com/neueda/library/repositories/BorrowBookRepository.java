package com.neueda.library.repositories;


import com.neueda.library.entity.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBook,Long> {


    List<BorrowBook> findByFromUserId_Id(Long userId);
    List<BorrowBook> findByFromBookId_Id(Long bookId);
}
