package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.FilmSoundtrack;
import com.amaizing.crudtemplate.repositories.FilmSoundtrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tables/film_soundtracks")
@AllArgsConstructor
public class FilmSoundtrackController {

    private final FilmSoundtrackRepository repository;

    @GetMapping
    public List<FilmSoundtrack> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public FilmSoundtrack create(@RequestBody FilmSoundtrack filmSoundtrack) {
        return repository.save(filmSoundtrack);
    }

    @PostMapping("/{id}")
    public FilmSoundtrack update(@PathVariable("id") Long id, @RequestBody FilmSoundtrack filmSoundtrack) {
        filmSoundtrack.setId(id);
        return repository.save(filmSoundtrack);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}