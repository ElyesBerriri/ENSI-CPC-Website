package com.cpc.backend.repositories;

import com.cpc.backend.models.Database;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DatabaseRepository extends MongoRepository<Database, Long> {
    Optional<Database> findDatabaseById(Long id);
}
