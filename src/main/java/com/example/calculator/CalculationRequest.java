package com.example.calculator;

import java.util.List;

/**
 * This class represents a calculation request, which is used as input to perform calculations.
 */
public class CalculationRequest {
    /**
     * The list of nodes that comprise this calculation request. These nodes represent mathematical operations or values.
     */
    private List<CalculationNode> nodes;

    // Add a no-argument constructor
    /**
     * Default constructor - initializes the nodes list as empty.
     */
    public CalculationRequest() {
    }

    /**
     * Constructor with parameter - sets the given list of nodes to this request's nodes list.
     *
     * @param nodes The nodes that comprise this calculation request.
     */
    public CalculationRequest(List<CalculationNode> nodes) {
        this.nodes = nodes;
    }

    /**
     * Getter method for the nodes list. Returns the current state of this request's nodes.
     *
     * @return The list of nodes that comprise this calculation request.
     */
    public List<CalculationNode> getNodes() {
        return nodes;
    }

    /**
     * Setter method for the nodes list. Sets the given nodes to this request's nodes.
     *
     * @param nodes The new set of nodes that should be used by this request.
     */
    public void setNodes(List<CalculationNode> nodes){
        this.nodes = nodes;
    }
}
