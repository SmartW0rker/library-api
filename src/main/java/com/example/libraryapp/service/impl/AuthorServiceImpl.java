package com.example.libraryapp.service.impl;

import com.example.libraryapp.exeptions.AuthorNotFound;
import com.example.libraryapp.exeptions.CountryNotFound;
import com.example.libraryapp.model.Author;
import com.example.libraryapp.model.Country;
import com.example.libraryapp.model.dto.AuthorDto;
import com.example.libraryapp.repository.AuthorRepository;
import com.example.libraryapp.repository.CountryRepository;
import com.example.libraryapp.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author delete(Long id) {
        Author author=authorRepository.findById(id)
                .orElseThrow(()->new AuthorNotFound(id));
        authorRepository.delete(author);
        return author;
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Country country=countryRepository.findById(authorDto.getCountryId())
                .orElseThrow(() ->new CountryNotFound(authorDto.getCountryId()));
        Author author=new Author(authorDto.getName(), authorDto.getSurname(), country);
        authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> edit(Long id, AuthorDto authorDto) {
        Author author=authorRepository.findById(id)
                .orElseThrow(()->new AuthorNotFound(id));
        Country country=countryRepository.findById(authorDto.getCountryId())
                .orElseThrow(() ->new CountryNotFound(authorDto.getCountryId()));

        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setCountry(country);

        authorRepository.save(author);
        return Optional.of(author);
    }
}
