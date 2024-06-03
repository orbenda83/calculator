package com.example.calculator;

import java.util.List;

public class CalculationRequest {
    private List<CalculationNode> nodes;

    // Add a no-argument constructor
    public CalculationRequest() {
    }

    public CalculationRequest(List<CalculationNode> nodes) {
        this.nodes = nodes;
    }

    // Getter and setter
    public List<CalculationNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<CalculationNode> nodes){
        this.nodes = nodes;
    }
}
