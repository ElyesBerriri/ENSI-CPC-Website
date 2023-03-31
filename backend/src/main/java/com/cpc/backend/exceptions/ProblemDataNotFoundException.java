package com.cpc.backend.exceptions;

public class ProblemDataNotFoundException extends RuntimeException {
    public ProblemDataNotFoundException(String message) {
        super(message);
    }
}
