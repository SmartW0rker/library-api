package com.example.libraryapp.exeptions;

public class AuthorNotFound extends RuntimeException{
    public AuthorNotFound(Long id) {
        super(String.format("Author with id: %d not found",id));
    }
}
