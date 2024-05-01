package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.StreamingPlatform;
import com.amaizing.crudtemplate.repositories.StreamingPlatformRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/tables/streaming_platforms")
@AllArgsConstructor
public class StreamingPlatformController {

    private final StreamingPlatformRepository repository;

    @GetMapping
    public List<StreamingPlatform> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public StreamingPlatform create(@RequestBody StreamingPlatform streamingPlatform) {
        return repository.save(streamingPlatform);
    }

    @PostMapping("/{id}")
    public StreamingPlatform update(@PathVariable("id") Long id, @RequestBody StreamingPlatform streamingPlatform) {
        streamingPlatform.setId(id);
        return repository.save(streamingPlatform);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}