package com.example.libraryapp.service.impl;

import com.example.libraryapp.exeptions.AuthorNotFound;
import com.example.libraryapp.exeptions.BookNotFound;
import com.example.libraryapp.model.Author;
import com.example.libraryapp.model.Book;
import com.example.libraryapp.model.dto.BookDto;
import com.example.libraryapp.repository.AuthorRepository;
import com.example.libraryapp.repository.BookRepository;
import com.example.libraryapp.service.AuthorService;
import com.example.libraryapp.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;

    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book delete(Long id) {
        Book book=bookRepository.findById(id)
                .orElseThrow(()->new BookNotFound(id));
        bookRepository.delete(book);
        return book;
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author=authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(()->new AuthorNotFound(bookDto.getAuthorId()));
        Book book=new Book(bookDto.getName(),bookDto.getCategory(),author,bookDto.getAvailableCopies());
        bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book=bookRepository.findById(id)
                .orElseThrow(()->new BookNotFound(id));
        Author author=authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(()->new AuthorNotFound(bookDto.getAuthorId()));

        book.setAuthor(author);
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        bookRepository.save(book);

        return Optional.of(book);
    }
}
