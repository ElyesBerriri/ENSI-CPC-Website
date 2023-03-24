package com.cpc.backend.services;

import com.cpc.backend.exceptions.DatabaseNotFoundException;
import com.cpc.backend.models.Database;
import com.cpc.backend.repositories.DatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DatabaseService {
    private  final DatabaseRepository databaseRepository;
    @Autowired
    public DatabaseService(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    public Database addDatabase(Database database) {
        return databaseRepository.save(database);
    }

    public List<Database> findAllDatabases() {
        return databaseRepository.findAll();
    }

    public Database updateDatabase(Database database){
        return databaseRepository.save(database);
    }

    public Database findDatabaseById(Long id){
        return databaseRepository.findDatabaseById(id).orElseThrow(()-> new DatabaseNotFoundException("User by id "+id+" was not found"));
    }

    public void deleteDatabase(Long id){
        databaseRepository.deleteById(id);
    }
}
