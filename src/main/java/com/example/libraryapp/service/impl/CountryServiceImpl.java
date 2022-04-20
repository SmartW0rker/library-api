package com.example.libraryapp.service.impl;

import com.example.libraryapp.exeptions.CountryNotFound;
import com.example.libraryapp.model.Country;
import com.example.libraryapp.model.dto.CountryDto;
import com.example.libraryapp.repository.CountryRepository;
import com.example.libraryapp.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);

    }

    @Override
    public Country delete(Long id) {
        Country country=countryRepository.findById(id)
                .orElseThrow(() ->new CountryNotFound(id));
        countryRepository.delete(country);
        return country;
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {
        Country country=new Country(countryDto.getName(),countryDto.getContinent());
        countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> edit(Long id, CountryDto countryDto) {
        Country country=countryRepository.findById(id)
                .orElseThrow(() ->new CountryNotFound(id));
        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());
        countryRepository.save(country);
        return Optional.of(country);
    }
}
