package com.marvis.mylibrary.service;

import com.marvis.mylibrary.data.dto.request.BookRequest;
import com.marvis.mylibrary.data.dto.response.BookResponse;
import com.marvis.mylibrary.data.model.Book;
import com.marvis.mylibrary.data.model.BorrowedBook;
import com.marvis.mylibrary.data.repository.BookRepository;
import com.marvis.mylibrary.exception.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    @CacheEvict(value = "allBooks", allEntries = true)
    public BookResponse addBook(BookRequest bookRequest) {
        Book book = Book.builder()
                .title(bookRequest.getTitle())
                .subject(bookRequest.getSubject())
                .authorFullName(bookRequest.getAuthorFullName())
                .isbn(bookRequest.getIsbn())
                .yearOfPublication(bookRequest.getYearOfPublication())
                .build();
       Book savedBook = bookRepository.save(book);

        return BookResponse.builder()
                .id(savedBook.getId())
                .title(savedBook.getTitle())
                .subject(savedBook.getSubject())
                .authorFullName(savedBook.getAuthorFullName())
                .yearOfPublication(savedBook.getYearOfPublication())
                .build();
    }

    @Override
    @CacheEvict(value = {"singleBook", "allBooks"}, key = "#id")
    public BookResponse borrowBook(BookRequest bookRequest) {
        Book book = Book.builder()
                .subject(bookRequest.getSubject())
                .title(bookRequest.getTitle())
                .authorFullName(bookRequest.getAuthorFullName())
                .yearOfPublication(bookRequest.getYearOfPublication())
                .build();

        Book borrowedBook = bookRepository.save(book);
        return null;
    }

    @Override
    @CacheEvict(value = {"singleBook", "allBooks"}, key = "#id")
    public String deleteBook(Long id) {
        String message = "Book successfully deleted";
        Book bookToDelete =  findBook(id);
        bookRepository.delete(bookToDelete);
         return message;
    }

    @Override
    public BookResponse findBookById(Long id) {
        Book foundBook = findBook(id);
        return BookResponse.builder()
                .id(foundBook.getId())
                .title(foundBook.getTitle())
                .subject(foundBook.getSubject())
                .authorFullName(foundBook.getAuthorFullName())
                .yearOfPublication(foundBook.getYearOfPublication())
                .build();
    }


    @Override
    public BookResponse findBookByTitle(String title) {
        Book bookFoundByTitle = bookRepository.findBookByTitleIgnoreCase(title);
        if (bookFoundByTitle == null) {
            throw new BookNotFoundException
                    (String.format("Book with title: %s not found", title));
        }
        return BookResponse.builder()
                .id(bookFoundByTitle.getId())
                .title(bookFoundByTitle.getTitle())
                .subject(bookFoundByTitle.getSubject())
                .authorFullName(bookFoundByTitle.getAuthorFullName())
                .yearOfPublication(bookFoundByTitle.getYearOfPublication())
                .build();
    }

    @Override
    public BookResponse findBookByIsbn(String isbn) {
        Book bookFoundByIsbn = bookRepository.findBookByIsbnIgnoreCase(isbn);
        if (bookFoundByIsbn == null) {
            throw new BookNotFoundException
                    (String.format("Book with ISBN: %s not found", isbn));
        }
        return BookResponse.builder()
                .id(bookFoundByIsbn.getId())
                .title(bookFoundByIsbn.getTitle())
                .subject(bookFoundByIsbn.getSubject())
                .authorFullName(bookFoundByIsbn.getAuthorFullName())
                .yearOfPublication(bookFoundByIsbn.getYearOfPublication())
                .build();
    }

    @Override
    @Cacheable(value = "allBooks")
    public List<BookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        return books.stream()
                .map(book -> new BookResponse( book.getId(), book.getTitle(),
                        book.getSubject(), book.getAuthorFullName(),
                        book.getYearOfPublication()))
                .collect(Collectors.toList());

    }


    private Book findBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException
                                (String.format("Book with id: %s not found", id)));
    }
}
