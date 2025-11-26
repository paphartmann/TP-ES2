package com.engsoft2.currencyhistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableFeignClients // Mantive comentado pois vamos usar dados mockados primeiro
public class CurrencyHistoryApplication { // <--- Alterado o nome da classe

    public static void main(String[] args) {
        SpringApplication.run(CurrencyHistoryApplication.class, args);
    }

}