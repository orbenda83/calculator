package com.example.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class acts as the entry point for calculation-related API calls.
 */
@RestController
public class CalculationController {
    /**
     * Injection of the CalculationService, which is responsible for performing actual calculations.
     */
    private final CalculationService calculationService;

    /**
     * Constructor that injects the CalculationService via Spring's dependency injection mechanism.
     *
     * @param calculationService
     */
    @Autowired
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    /**
     * Handles POST requests to "/calculate" endpoint. This method is responsible for receiving a request object,
     * performing calculations using the injected CalculationService, and returning the results.
     *
     * @param request
     *            The request object containing data for the calculations.
     * @return A ResponseEntity with a Map containing the calculation results.
     */
    @PostMapping("/calculate")
    public ResponseEntity<Map<String, Object>> calculate(@RequestBody CalculationRequest request) {
        /**
         * Perform calculations using the injected CalculationService and store the results in a list.
         */
        List<Double> results = calculationService.performCalculations(request);

        /**
         * Create a response map that will be returned as part of the ResponseEntity.
         */
        Map<String, Object> response = new HashMap<>();
        response.put("results", results);

        /**
         * Return a ResponseEntity with the calculated results, indicating success (200 OK).
         */
        return ResponseEntity.ok(response);
    }
}
