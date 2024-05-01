package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.StreamingPlatform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreamingPlatformRepository extends JpaRepository<StreamingPlatform, Long> {

    List<StreamingPlatform> findAllByOrderByIdAsc();
}
