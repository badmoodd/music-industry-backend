package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Genre;
import com.amaizing.crudtemplate.repositories.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tables/genres")
@AllArgsConstructor
public class GenreController {

    private final GenreRepository repository;

    @GetMapping
    public List<Genre> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public Genre create(@RequestBody Genre genre) {
        return repository.save(genre);
    }

    @PostMapping("/{id}")
    public Genre update(@PathVariable("id") Long id, @RequestBody Genre genre) {
        genre.setId(id);
        return repository.save(genre);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}