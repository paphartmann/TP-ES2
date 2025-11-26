package com.engsoft2.currencyreport;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyReportController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    @GetMapping("/quote")
    public Map<String, Object> getQuote(@RequestParam String from, @RequestParam String to) {
        // Busca os dados do outro microsserviço
        CurrencyExchangeDto response = proxy.retrieveExchangeValue(from, to);
        
        // Monta o JSON exatamente como o enunciado pede
        Map<String, Object> result = new HashMap<>();
        result.put("from", response.getFrom());
        result.put("to", response.getTo());
        result.put("price", response.getConversionMultiple()); // Mapeia conversionMultiple para price
        result.put("timestamp", LocalDateTime.now().toString()); // Adiciona o timestamp atual
        
        return result;
    }
}