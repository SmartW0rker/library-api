package com.example.libraryapp.service;

import com.example.libraryapp.model.Book;
import com.example.libraryapp.model.dto.BookDto;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book delete(Long id);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> edit(Long id,BookDto bookDto);
}
