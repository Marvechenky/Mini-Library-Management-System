package com.marvis.mylibrary.data.repository;

import com.marvis.mylibrary.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByTitleIgnoreCase(String title);

    Book findBookByIsbnIgnoreCase(String isbn);
}
