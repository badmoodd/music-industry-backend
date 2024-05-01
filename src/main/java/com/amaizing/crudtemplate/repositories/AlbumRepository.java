package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findAllByOrderByIdAsc();
}
