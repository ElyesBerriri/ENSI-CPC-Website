package com.cpc.backend.models;

import jakarta.persistence.*;
@Entity
@Table(name = "pbdata")
public class ProblemData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    Long id;
    @Column
    Long id_problem;
    @Column
    String input;
    @Column
    String output;

    public ProblemData() {
    }

    public ProblemData(Long id, Long id_problem, String input, String output) {
        this.id = id;
        this.id_problem = id_problem;
        this.input = input;
        this.output = output;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_problem() {
        return id_problem;
    }

    public void setId_problem(Long id_problem) {
        this.id_problem = id_problem;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
