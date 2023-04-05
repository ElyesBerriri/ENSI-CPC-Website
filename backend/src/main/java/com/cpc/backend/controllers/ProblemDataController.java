package com.cpc.backend.controllers;

import com.cpc.backend.models.*;
import com.cpc.backend.services.ProblemDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/problemDatas")
public class ProblemDataController {
    private final ProblemDataService problemDataService;

    public ProblemDataController(ProblemDataService problemDataService) {
        this.problemDataService = problemDataService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProblemData>> getAllProblemDatas(){
        List<ProblemData> problemDatas = problemDataService.findAllProblemDatas();
        return new ResponseEntity<>(problemDatas, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<ProblemData> getProblemDataById(@PathVariable("id") Long id){
        ProblemData problemData = problemDataService.findProblemDataById(id);
        return new ResponseEntity<>(problemData, HttpStatus.OK);
    }

    @GetMapping("/findOutput/{id}")
    public ResponseEntity<String> getProblemOutputById(@PathVariable("id") Long id){
       // String problemData = problemDataService.findProblemOutputById(id);
       // return new ResponseEntity<>(problemData, HttpStatus.OK);
        return null;
    }

    @PostMapping("/add")
    public ResponseEntity<ProblemData> addProblemData(@RequestBody ProblemData problemData){
        ProblemData newProblemData = problemDataService.addProblemData(problemData);
        return new ResponseEntity<>(newProblemData, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ProblemData> updateProblemData(@RequestBody ProblemData problemData){
        ProblemData updateProblemData = problemDataService.updateProblemData(problemData);
        return new ResponseEntity<>(updateProblemData, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProblemData(@PathVariable("id") Long id){
        problemDataService.deleteProblemData(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/execute/{id_problem}")
    public boolean SubmitCode(@PathVariable("id") Long id,@RequestBody Input in){
        boolean flag = problemDataService.SubmitCode(id,in);
        return flag;
    }

    @GetMapping("/extractMyProblem/{id_problem}")
    public ResponseEntity<List<InputOutput>> ExtractProblem(@PathVariable("id_problem") Long id){
        List<InputOutput>  pb = problemDataService.findProblemInputOutputById(id);
        return new ResponseEntity<>(pb, HttpStatus.OK);
    }

}
