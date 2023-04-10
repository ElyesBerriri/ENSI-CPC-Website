
package com.cpc.backend.services;

import com.cpc.backend.exceptions.ProblemDataNotFoundException;
import com.cpc.backend.models.Input;
import com.cpc.backend.models.InputOutput;
import com.cpc.backend.models.Output;
import com.cpc.backend.models.ProblemData;
import com.cpc.backend.repositories.ProblemDataRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProblemDataService {
    private  final ProblemDataRepository problemRepository;
    @Autowired
    public ProblemDataService(ProblemDataRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public ProblemData addProblemData(ProblemData problem) {
        return problemRepository.save(problem);
    }

    public List<ProblemData> findAllProblemDatas() {
        return problemRepository.findAll();
    }

    public ProblemData updateProblemData(ProblemData problem){
        return problemRepository.save(problem);
    }

    public ProblemData findProblemDataById(Long id){
        return problemRepository.findProblemDataById(id).orElseThrow(()-> new ProblemDataNotFoundException("User by id "+id+" was not found"));
    }

    public void deleteProblemData(Long id){
        problemRepository.deleteById(id);
    }


    public Output Submit(Input in,String stdin) {
        JdoodleAPI request=new JdoodleAPI();
        Output output;
        String out;
        out=request.ExecuteCodeWithStdIn(in,stdin);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            output = objectMapper.readValue(out, Output.class);
            return output;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String> findProblemOutputById(Long id){
        List<ProblemData> pb;
        List<String> result = new ArrayList<String>();
        //pb=problemRepository.findProblemDataById(id).orElseThrow(()-> new ProblemDataNotFoundException("User by id "+id+" was not found"));
        //return pb.getOutput();
        pb=problemRepository.findByIdProblem(id);
        for(ProblemData element : pb) {
            result.add(element.getOutput());
        }
        return result;
    }

    public List<InputOutput> findProblemInputOutputById(Long id){
        List<ProblemData> pb;
        List<InputOutput> result = new ArrayList<InputOutput>();
        InputOutput inout=new InputOutput();
        //pb=problemRepository.findProblemDataById(id).orElseThrow(()-> new ProblemDataNotFoundException("User by id "+id+" was not found"));
        //return pb.getOutput();
        pb=problemRepository.findByIdProblem(id);
        for(ProblemData element : pb) {
            inout.setInput(element.getInput());
            inout.setOutput(element.getInput());
            result.add(inout);
        }
        return result;
    }
    public boolean SubmitCode(Long id, Input in)
    {
        boolean flag=true;
        List<InputOutput> InOut=findProblemInputOutputById(id);
        for(InputOutput element : InOut) {
            Output o=Submit(in, element.getInput());
            System.out.println("test-before:"+o.getOutput()+element.getInput());
            if(!(o.getOutput().equals(element.getOutput())))
            {
                System.out.println("test22:"+o.getOutput()+element.getInput());
                return false;
            }

        }
        return flag;
    }

    public List<ProblemData> ExtractProblem(Long id) {
        try {
            return problemRepository.findByIdProblem(id);
        }catch (Exception e) {
            // Handle the exception
        }
        return null;

    }
}
