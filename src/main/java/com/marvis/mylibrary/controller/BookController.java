package com.marvis.mylibrary.controller;

import com.marvis.mylibrary.data.dto.request.BookRequest;
import com.marvis.mylibrary.data.dto.request.BorrowBookRequest;
import com.marvis.mylibrary.data.dto.response.BookResponse;
import com.marvis.mylibrary.data.dto.response.BorrowedBookResponse;
import com.marvis.mylibrary.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @PostMapping("/books/add")
    public ResponseEntity<BookResponse> addBooks(@RequestBody @Valid BookRequest bookRequest) {
        BookResponse addedBook = bookService.addBook(bookRequest);
        return new ResponseEntity<>(addedBook, HttpStatus.CREATED);
    }

    @GetMapping("/books/borrow")
    public ResponseEntity<BorrowedBookResponse> borrowBook(@RequestBody @Valid BorrowBookRequest borrowBookRequest) {
        BorrowedBookResponse borrowedBook = bookService.borrowBook(borrowBookRequest);
        return new ResponseEntity<>(borrowedBook, HttpStatus.OK);
    }


    @GetMapping("/books/all")
    public ResponseEntity<List<BookResponse>> getBooks() {
        List<BookResponse> responses = bookService.getAllBooks();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable Long id) {
        BookResponse bookWithId = bookService.findBookById(id);
        return new ResponseEntity<>(bookWithId, HttpStatus.OK);
    }

    @GetMapping("/books/title/{title}")
    public ResponseEntity<BookResponse> getBookByTitle(@PathVariable String title) {
        BookResponse bookWithTitle = bookService.findBookByTitle(title);
        return new ResponseEntity<>(bookWithTitle, HttpStatus.OK);
    }

    @GetMapping("/books/isbn/{isbn}")
    public ResponseEntity<BookResponse> getBookByIsbn(@PathVariable String isbn) {
        BookResponse bookWithIsbn = bookService.findBookByIsbn(isbn);
        return new ResponseEntity<>(bookWithIsbn, HttpStatus.OK);
    }


    @DeleteMapping("/books/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        String deleteMessage = "Book successfully deleted";
            bookService.deleteBook(id);
        return new ResponseEntity<>(deleteMessage,HttpStatus.OK);
    }

}
