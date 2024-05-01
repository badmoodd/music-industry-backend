package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    List<Playlist> findAllByOrderByIdAsc();
}
