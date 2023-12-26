package com.marvis.mylibrary.data.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "borrowed_books")
public class BorrowedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_category")
    private String subject;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "author_name")
    private String bookAuthor;

}
