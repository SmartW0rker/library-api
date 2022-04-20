package com.example.libraryapp.model.dto;

import lombok.Data;

@Data
public class AuthorDto {
    private String name;
    private String surname;
    private Long countryId;

    public AuthorDto(String name, String surname, Long countryId) {
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
    }

    public AuthorDto() {
    }
}
