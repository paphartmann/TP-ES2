package com.engsoft2.currencyhistory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyHistoryController {

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    @GetMapping("/history")
    public Map<String, Object> getHistory(@RequestParam String from, @RequestParam String to) {
        // Estrutura principal do JSON
        Map<String, Object> response = new HashMap<>();
        response.put("from", from);
        response.put("to", to);
        
        // Criando lista de valores mockados
        List<Map<String, Object>> values = new ArrayList<>();
        
        // Gerar 3 valores de histórico fictícios
        double basePrice = 5.0; // Preço base fictício
        for (int i = 0; i < 3; i++) {
            Map<String, Object> dataPoint = new HashMap<>();
            dataPoint.put("timestamp", LocalDateTime.now().minusHours(i).toString());
            // Preço varia um pouco aleatoriamente
            dataPoint.put("price", basePrice + (new Random().nextDouble())); 
            values.add(dataPoint);
        }

        response.put("values", values);
        
        return response;
    }
}