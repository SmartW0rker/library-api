package com.example.libraryapp.service;

import com.example.libraryapp.model.Country;
import com.example.libraryapp.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Country delete(Long id);
    Optional<Country> save(CountryDto countryDto);
    Optional<Country> edit(Long id,CountryDto countryDto);
}
