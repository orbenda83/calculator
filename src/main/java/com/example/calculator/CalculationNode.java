package com.example.calculator;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * A class representing a calculation node in a calculator.
 */
public class CalculationNode {
    /**
     * The value associated with this node (e.g., a number).
     */
    private double value;
    
    /**
     * The operation that should be performed on the value (e.g., addition, subtraction, multiplication, etc.).
     */
    private String operation;
    
    /**
     * A list of nodes that this node depends on for its calculation.
     */
    private List<Integer> dependencies;

    /**
     * Constructor.
     *
     * @param value The initial value associated with this node.
     * @param operation The initial operation to be performed on the value.
     * @param dependencies The initial list of nodes that this node depends on.
     */
    public CalculationNode(@JsonProperty("value") double value,
            @JsonProperty("operation") String operation,
            @JsonProperty("dependencies") List<Integer> dependencies) {
        this.value = value;
        this.operation = operation;
        this.dependencies = dependencies;
    }

    // Getters and setters
    /**
     * Gets the value associated with this node.
     *
     * @return The value associated with this node.
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the value associated with this node.
     *
     * @param value The new value to be associated with this node.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Gets the operation that should be performed on the value.
     *
     * @return The operation that should be performed on the value.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the operation that should be performed on the value.
     *
     * @param operation The new operation to be performed on the value.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Gets a list of nodes that this node depends on for its calculation.
     *
     * @return A list of nodes that this node depends on.
     */
    public List<Integer> getDependencies() {
        return dependencies;
    }

    /**
     * Sets a list of nodes that this node depends on for its calculation.
     *
     * @param dependencies The new list of nodes that this node depends on.
     */
    public void setDependencies(List<Integer> dependencies) {
        this.dependencies = dependencies;
    }
}