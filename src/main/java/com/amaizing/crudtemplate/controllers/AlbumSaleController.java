package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.AlbumSale;
import com.amaizing.crudtemplate.repositories.AlbumSaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tables/album_sales")
@AllArgsConstructor
public class AlbumSaleController {

    private final AlbumSaleRepository repository;

    @GetMapping
    public List<AlbumSale> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public AlbumSale create(@RequestBody AlbumSale albumSale) {
        return repository.save(albumSale);
    }

    @PostMapping("/{id}")
    public AlbumSale update(@PathVariable("id") Long id, @RequestBody AlbumSale albumSale) {
        albumSale.setId(id);
        return repository.save(albumSale);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}