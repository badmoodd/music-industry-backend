package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Artist;
import com.amaizing.crudtemplate.repositories.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/tables/artists")
@AllArgsConstructor
public class ArtistController {

    private final ArtistRepository repository;

    @GetMapping
    public List<Artist> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public Artist create(@RequestBody Artist artist) {
        return repository.save(artist);
    }

    @PostMapping("/{id}")
    public Artist update(@PathVariable("id") Long id, @RequestBody Artist artist) {
        artist.setId(id);
        return repository.save(artist);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}