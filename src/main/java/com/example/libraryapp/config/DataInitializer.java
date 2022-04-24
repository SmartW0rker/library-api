package com.example.libraryapp.config;

import com.example.libraryapp.model.Author;
import com.example.libraryapp.model.Category;
import com.example.libraryapp.model.Country;
import com.example.libraryapp.model.dto.AuthorDto;
import com.example.libraryapp.model.dto.BookDto;
import com.example.libraryapp.model.dto.CountryDto;
import com.example.libraryapp.service.AuthorService;
import com.example.libraryapp.service.BookService;
import com.example.libraryapp.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Component
public class DataInitializer {

    private final BookService bookService;

    private final AuthorService authorService;
    private final CountryService countryService;

    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    private Category randomizeCategory(int i) {
        if (i % 7 == 0) return Category.NOVEL;
        else if (i % 7 == 1) return Category.THRILER;
        else if (i % 7 == 2) return Category.HISTORY;
        else if (i % 7 == 3) return Category.FANTASY;
        else if (i % 7 == 4) return Category.BIOGRAPHY;
        else if (i % 7 == 5) return Category.CLASSICS;
        return Category.DRAMA;
    }

    @PostConstruct
    public void initData() {
        this.countryService.save(new CountryDto("Macedonia", "Europe"));
        this.countryService.save(new CountryDto("USA", "North America"));
        this.countryService.save(new CountryDto("Italy", "Europe"));
        List<Country> countries = this.countryService.findAll();
        Country macedonia = this.countryService.findByName("Macedonia");
        Country usa = this.countryService.findByName("USA");
        Country italy = this.countryService.findByName("Italy");
        this.authorService.save(
                new AuthorDto("Petre", "M. Andrevski", macedonia.getId()));
        this.authorService.save(
                new AuthorDto("Donato", "Carrisi", italy.getId()));
        this.authorService.save(
                new AuthorDto("Linvud", "Barkli", usa.getId()));

        List<Author> authors = authorService.findAll();
        Random random=new Random();
        for (int i = 1; i < 30; i++) {
            this.bookService.save(
                    new BookDto("Book: " + i,
                            this.randomizeCategory(i),
                            authors.get((i - 1) % 3).getId(),
                            random.nextInt(10))
            );
        }
    }
}
