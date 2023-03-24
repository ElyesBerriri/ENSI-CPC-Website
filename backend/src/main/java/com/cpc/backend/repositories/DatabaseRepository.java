package com.cpc.backend.repositories;

import com.cpc.backend.models.Database;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DatabaseRepository extends JpaRepository<Database, Long>{
    Optional<Database> findDatabaseById(Long id);
}
