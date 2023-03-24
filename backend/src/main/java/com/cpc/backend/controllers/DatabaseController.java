package com.cpc.backend.controllers;

import com.cpc.backend.models.Database;
import com.cpc.backend.services.DatabaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/databases")
public class DatabaseController {
    private final DatabaseService databaseService;

    public DatabaseController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Database>> getAllDatabases(){
        List<Database> databases = databaseService.findAllDatabases();
        return new ResponseEntity<>(databases, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Database> getDatabaseById(@PathVariable("id") Long id){
        Database database = databaseService.findDatabaseById(id);
        return new ResponseEntity<>(database, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Database> addDatabase(@RequestBody Database database){
        Database newDatabase = databaseService.addDatabase(database);
        return new ResponseEntity<>(newDatabase, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Database> updateDatabase(@RequestBody Database database){
        Database updateDatabase = databaseService.updateDatabase(database);
        return new ResponseEntity<>(updateDatabase, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDatabase(@PathVariable("id") Long id){
        databaseService.deleteDatabase(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
