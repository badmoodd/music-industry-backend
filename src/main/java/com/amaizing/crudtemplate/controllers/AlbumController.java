package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Album;
import com.amaizing.crudtemplate.repositories.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tables/albums")
@AllArgsConstructor
public class AlbumController {

    private final AlbumRepository repository;

    @GetMapping
    public List<Album> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public Album create(@RequestBody Album album) {
        return repository.save(album);
    }

    @PostMapping("/{id}")
    public Album update(@PathVariable("id") Long id, @RequestBody Album album) {
        album.setId(id);
        return repository.save(album);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}
