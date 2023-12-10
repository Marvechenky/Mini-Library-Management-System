package com.marvis.mylibrary.data.repository;

import com.marvis.mylibrary.data.model.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
}
