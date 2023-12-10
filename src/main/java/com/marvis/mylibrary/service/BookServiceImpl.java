package com.marvis.mylibrary.service;

import com.marvis.mylibrary.data.dto.request.BookRequest;
import com.marvis.mylibrary.data.dto.response.BookResponse;
import com.marvis.mylibrary.data.model.Author;
import com.marvis.mylibrary.data.model.Book;
import com.marvis.mylibrary.data.repository.AuthorRepository;
import com.marvis.mylibrary.data.repository.BookRepository;
import com.marvis.mylibrary.exception.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public BookResponse addBook(BookRequest bookRequest) {
        Author author = authorRepository.findByFullName(bookRequest.getAuthor().getFullName());

        if (author == null) {
            author = Author.builder()
                    .fullName(bookRequest.getAuthor().getFullName())
                    .build();
            author = authorRepository.save(author);
        }
        Book book = Book.builder()
                .title(bookRequest.getTitle())
                .subject(bookRequest.getSubject())
                .author(author)
                .isbn(bookRequest.getIsbn())
                .yearOfPublication(bookRequest.getYearOfPublication())
                .build();

       Book savedBook = bookRepository.save(book);
        return BookResponse.builder()
                .id(savedBook.getId())
                .title(savedBook.getTitle())
                .subject(savedBook.getSubject())
                .authorFullName(savedBook.getAuthor().getFullName())
                .yearOfPublication(savedBook.getYearOfPublication())
                .build();

//        BookResponse response = BookResponse.builder()
//                .id(savedBook.getId())
//                .title(savedBook.getTitle())
//                .subject(savedBook.getSubject())
//                .authorFullName(savedBook.getAuthor().getFullName())
//                .yearOfPublication(savedBook.getYearOfPublication())
//                .build();
//        return response;
    }

    @Override
    public BookResponse borrowBook(BookRequest bookRequest) {
        return null;
    }

    @Override
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
                .title(foundBook.getTitle())
                .subject(foundBook.getSubject())
                .authorFullName(foundBook.getAuthor().getFullName())
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
                .title(bookFoundByTitle.getTitle())
                .subject(bookFoundByTitle.getSubject())
                .authorFullName(bookFoundByTitle.getAuthor().getFullName())
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
                .title(bookFoundByIsbn.getTitle())
                .subject(bookFoundByIsbn.getSubject())
                .authorFullName(bookFoundByIsbn.getAuthor().getFullName())
                .yearOfPublication(bookFoundByIsbn.getYearOfPublication())
                .build();
    }

    @Override
    public List<BookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        return books.stream()
                .map(book -> new BookResponse( book.getId(), book.getTitle(),
                        book.getSubject(), book.getAuthor().getFullName(),
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
