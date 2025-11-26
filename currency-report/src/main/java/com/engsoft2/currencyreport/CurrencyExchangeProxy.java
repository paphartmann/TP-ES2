package com.engsoft2.currencyreport;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// AQUI ESTÁ O REQUISITO: Usamos o NOME do serviço, não o IP ou localhost
@FeignClient(name = "currency-exchange") 
public interface CurrencyExchangeProxy {
    
    // Mapeamos o endpoint do outro serviço que queremos chamar
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeDto retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}