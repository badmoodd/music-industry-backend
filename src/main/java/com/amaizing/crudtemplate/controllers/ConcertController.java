package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Concert;
import com.amaizing.crudtemplate.repositories.ConcertRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tables/concerts")
@AllArgsConstructor
public class ConcertController {

    private final ConcertRepository repository;

    @GetMapping
    public List<Concert> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public Concert create(@RequestBody Concert concert) {
        return repository.save(concert);
    }

    @PostMapping("/{id}")
    public Concert update(@PathVariable("id") Long id, @RequestBody Concert concert) {
        concert.setId(id);
        return repository.save(concert);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}