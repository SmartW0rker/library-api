package com.example.libraryapp.repository;

import com.example.libraryapp.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
    @Override
    List<Country> findAll();

    @Override
    Optional<Country> findById(Long aLong);
}
