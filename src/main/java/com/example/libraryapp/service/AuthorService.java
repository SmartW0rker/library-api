package com.example.libraryapp.service;

import com.example.libraryapp.model.Author;
import com.example.libraryapp.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Author delete(Long id);
    Optional<Author> save(AuthorDto authorDto);
    Optional<Author> edit(Long id,AuthorDto authorDto);
}
