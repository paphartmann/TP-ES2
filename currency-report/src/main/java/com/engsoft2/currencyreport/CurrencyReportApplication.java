package com.engsoft2.currencyreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients; // Só necessário se for comunicar com outros serviços agora

@SpringBootApplication
@EnableFeignClients // Mantive comentado pois vamos usar dados mockados primeiro
public class CurrencyReportApplication { // <--- Alterado o nome da classe

    public static void main(String[] args) {
        SpringApplication.run(CurrencyReportApplication.class, args);
    }

}