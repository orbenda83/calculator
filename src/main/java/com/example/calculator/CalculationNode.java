package com.example.calculator;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CalculationNode {
    private double value;
    private String operation;
    private List<Integer> dependencies;

    public CalculationNode(@JsonProperty("value") double value,
            @JsonProperty("operation") String operation,
            @JsonProperty("dependencies") List<Integer> dependencies) {
        this.value = value;
        this.operation = operation;
        this.dependencies = dependencies;
    }

    // Getters and setters
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public List<Integer> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Integer> dependencies) {
        this.dependencies = dependencies;
    }
}