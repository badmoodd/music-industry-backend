package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.FilmSoundtrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmSoundtrackRepository extends JpaRepository<FilmSoundtrack, Long> {

    List<FilmSoundtrack> findAllByOrderByIdAsc();
}
