
package com.cpc.backend.services;

import com.cpc.backend.exceptions.ProblemDataNotFoundException;
import com.cpc.backend.models.Input;
import com.cpc.backend.models.Output;
import com.cpc.backend.models.ProblemData;
import com.cpc.backend.repositories.ProblemDataRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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


    public Output Submit(Input in) {
        JdoodleAPI request=new JdoodleAPI();
        Output output;
        String out;
        out=request.ExecuteCode(in);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            output = objectMapper.readValue(out, Output.class);
            return output;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public String findProblemOutputById(Long id){
        ProblemData pb;
        pb=problemRepository.findProblemDataById(id).orElseThrow(()-> new ProblemDataNotFoundException("User by id "+id+" was not found"));
        return pb.getOutput();
    }
    public boolean SubmitCode(Long id, Input in)
    {
        String tableOutput=findProblemOutputById(id);
        Output o=Submit(in);
        String codeOutput=o.getOutput();
        if(tableOutput==codeOutput)
            return true;
        else
            return false;

    }
}
