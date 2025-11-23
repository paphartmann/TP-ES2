package com.engsoft2.currencyreport;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyReportController {

    // Requisito 1: GET /health
    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        return status;
    }

    // Requisito 2: GET /quote (Mockado)
    @GetMapping("/quote")
    public Map<String, Object> getQuote(
            @RequestParam String from,
            @RequestParam String to
    ) {
        Map<String, Object> response = new HashMap<>();
        response.put("from", from);
        response.put("to", to);
        response.put("price", 5.42); // Valor mockado fixo
        response.put("timestamp", LocalDateTime.now().toString());
        
        return response;
    }
}