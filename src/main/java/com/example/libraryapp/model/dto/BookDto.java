package com.example.libraryapp.model.dto;

import com.example.libraryapp.model.Author;
import com.example.libraryapp.model.Category;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Data
public class BookDto {
    private String name;
    private Category category;
    private Long authorId;
    private Integer availableCopies;

    public BookDto(String name, Category category, Long id, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = id;
        this.availableCopies = availableCopies;
    }

    public BookDto() {
    }
}
