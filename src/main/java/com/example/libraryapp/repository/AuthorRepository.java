package com.example.libraryapp.repository;

import com.example.libraryapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Override
    List<Author> findAll();

    @Override
    Optional<Author> findById(Long aLong);
}
