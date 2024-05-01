package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.SongSale;
import com.amaizing.crudtemplate.repositories.SongSaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/tables/song_sales")
@AllArgsConstructor
public class SongSaleController {

    private final SongSaleRepository repository;

    @GetMapping
    public List<SongSale> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public SongSale create(@RequestBody SongSale songSale) {
        return repository.save(songSale);
    }

    @PostMapping("/{id}")
    public SongSale update(@PathVariable("id") Long id, @RequestBody SongSale songSale) {
        songSale.setId(id);
        return repository.save(songSale);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}