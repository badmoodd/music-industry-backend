package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    List<Genre> findAllByOrderByIdAsc();
}
