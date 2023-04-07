package com.cpc.backend.models;

public class InputOutput {
    String input;
    String output;

    public InputOutput() {
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

    @Override
    public String toString() {
        return "InputOutput{" +
                "input='" + input + '\'' +
                ", output='" + output + '\'' +
                '}';
    }

    public InputOutput(String input, String output) {
        this.input = input;
        this.output = output;
    }
}
