package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Song;
import com.amaizing.crudtemplate.repositories.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tables/songs")
@AllArgsConstructor
public class SongController {

    private final SongRepository repository;

    @GetMapping
    public List<Song> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public Song create(@RequestBody Song song) {
        return repository.save(song);
    }

    @PostMapping("/{id}")
    public Song update(@PathVariable("id") Long id, @RequestBody Song song) {
        song.setId(id);
        return repository.save(song);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}