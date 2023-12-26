package com.marvis.mylibrary.service;

import com.marvis.mylibrary.data.dto.request.BookRequest;
import com.marvis.mylibrary.data.dto.request.BorrowBookRequest;
import com.marvis.mylibrary.data.dto.response.BookResponse;
import com.marvis.mylibrary.data.dto.response.BorrowedBookResponse;

import java.util.List;


public interface BookService {

    BookResponse addBook(BookRequest bookRequest);

    BorrowedBookResponse borrowBook(BorrowBookRequest borrowBookRequest);

    String deleteBook(Long id);

    BookResponse findBookById(Long id);

    BookResponse findBookByTitle(String title);

    BookResponse findBookByIsbn(String isbn);

    List<BookResponse> getAllBooks();
}
