package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.SongSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongSaleRepository extends JpaRepository<SongSale, Long> {

    List<SongSale> findAllByOrderByIdAsc();
}
