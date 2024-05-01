package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {

    List<Concert> findAllByOrderByIdAsc();
}
