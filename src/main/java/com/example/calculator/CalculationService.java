package com.example.calculator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculationService {
    public List<Double> performCalculations(CalculationRequest request) {
        List<CalculationNode> nodes = request.getNodes();
        List<Double> results = new ArrayList<>(nodes.size());

        for (CalculationNode node : nodes) {
            double value = node.getValue();
            String operation = node.getOperation();
            List<Integer> dependencies = node.getDependencies();

            double result;
            switch (operation) {
                case "assign":
                    result = value;
                    System.out.println("Assigning " + node.getValue() + " to variable " + nodes.indexOf(node));
                    break;
                case "add":
                    result = value;
                    for (int index : dependencies) {
                        System.out.println("Adding " + result + " to " + results.get(index) + " to variable " + nodes.indexOf(node));
                        result += results.get(index);
                    }
                    break;
                case "subtract":
                    result = value;
                    for (int index : dependencies) {
                        System.out.println("Substructing " + result + " to " + results.get(index) + " to variable " + nodes.indexOf(node));
                        result -= results.get(index);
                    }
                    break;
                case "multiply":
                    result = value;
                    for (int index : dependencies) {
                        System.out.println("Multiplying " + result + " to " + results.get(index) + " to variable " + nodes.indexOf(node));
                        result *= results.get(index);
                    }
                    break;
                case "divide":
                    result = value;
                    for (int index : dependencies) {
                        double dependencyValue = results.get(index);
                        if (dependencyValue == 0) {
                            throw new IllegalArgumentException("Cannot divide by zero");
                        }
                        System.out.println("Dividing " + result + " to " + results.get(index) + " to variable " + nodes.indexOf(node));
                        result /= dependencyValue;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation: " + operation);
            }

            results.add(result);
        }

        return results;
    }
}