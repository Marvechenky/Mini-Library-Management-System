package com.marvis.mylibrary.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "title field is required")
    @Column(name = "book_title")
    private String title;

    @NotBlank(message = "subject field is required")
    @Column(name = "book_category")
    private String subject;

    @Column(name = "author_name")
    private String authorFullName;

//    @ManyToOne
//    @JoinColumn(name = "author_id")
//    private Author author;

    @NotBlank(message = "isbn field is required")
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publication_year")
    private LocalDate yearOfPublication;


}
