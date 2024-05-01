package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
