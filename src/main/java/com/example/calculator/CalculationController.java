package com.example.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CalculationController {
    private final CalculationService calculationService;

    @Autowired
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Map<String, Object>> calculate(@RequestBody CalculationRequest request) {
        List<Double> results = calculationService.performCalculations(request);

        Map<String, Object> response = new HashMap<>();
        response.put("results", results);

        return ResponseEntity.ok(response);
    }
}
