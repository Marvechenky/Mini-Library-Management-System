package com.marvis.mylibrary.data.repository;

import com.marvis.mylibrary.data.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByFullName(String fullName);
}
