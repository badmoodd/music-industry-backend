package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Playlist;
import com.amaizing.crudtemplate.repositories.PlaylistRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tables/playlists")
@AllArgsConstructor
public class PlaylistController {

    private final PlaylistRepository repository;

    @GetMapping
    public List<Playlist> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public Playlist create(@RequestBody Playlist playlist) {
        return repository.save(playlist);
    }

    @PostMapping("/{id}")
    public Playlist update(@PathVariable("id") Long id, @RequestBody Playlist playlist) {
        playlist.setId(id);
        return repository.save(playlist);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}