package com.marvis.mylibrary.service;

import com.marvis.mylibrary.data.dto.request.BookRequest;
import com.marvis.mylibrary.data.model.Book;

public interface BookService {

    Book addBook(BookRequest bookRequest);

    
}
