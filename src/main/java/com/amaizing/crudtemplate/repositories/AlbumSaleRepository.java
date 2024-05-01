package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.AlbumSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumSaleRepository extends JpaRepository<AlbumSale, Long> {

    List<AlbumSale> findAllByOrderByIdAsc();
}
