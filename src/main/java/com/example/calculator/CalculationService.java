package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * This service performs calculations based on a given calculation request.
 */
@Service
public class CalculationService {
    /**
     * Performs the specified calculations and returns the results as a list of doubles.
     *
     * @param request The calculation request containing the nodes to be calculated.
     * @return A list of double values representing the results of the calculations.
     */
    public List<Double> performCalculations(CalculationRequest request) {
        /**
         * Get the nodes from the request.
         */
        List<CalculationNode> nodes = request.getNodes();
        /**
         * Initialize a list to store the results.
         */
        List<Double> results = new ArrayList<>(nodes.size());

        for (CalculationNode node : nodes) {
            double value = node.getValue();
            String operation = node.getOperation();
            List<Integer> dependencies = node.getDependencies();

            double result;
            switch (operation) {
                case "assign":
                    /**
                     * Assign the given value to a variable.
                     */
                    result = value;
                    System.out.println("Assigning " + node.getValue() + " to variable " + nodes.indexOf(node));
                    break;
                case "add":
                    /**
                     * Add the given value to multiple variables and store the sum in the result.
                     */
                    result = value;
                    for (int index : dependencies) {
                        System.out.println("Adding " + result + " to " + results.get(index) + " to variable " + nodes.indexOf(node));
                        result += results.get(index);
                    }
                    break;
                case "subtract":
                    /**
                     * Subtract the given value from multiple variables and store the difference in the result.
                     */
                    result = value;
                    for (int index : dependencies) {
                        System.out.println("Substructing " + result + " to " + results.get(index) + " to variable " + nodes.indexOf(node));
                        result -= results.get(index);
                    }
                    break;
                case "multiply":
                    /**
                     * Multiply the given value by multiple variables and store the product in the result.
                     */
                    result = value;
                    for (int index : dependencies) {
                        System.out.println("Multiplying " + result + " to " + results.get(index) + " to variable " + nodes.indexOf(node));
                        result *= results.get(index);
                    }
                    break;
                case "divide":
                    /**
                     * Divide the given value by multiple variables and store the quotient in the result.
                     */
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
                    /**
                     * Throw an exception for invalid operations.
                     */
                    throw new IllegalArgumentException("Invalid operation: " + operation);
            }

            /**
             * Add the calculated result to the list of results.
             */
            results.add(result);
        }

        return results;
    }
}
