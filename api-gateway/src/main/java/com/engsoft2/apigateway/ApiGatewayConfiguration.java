package com.engsoft2.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                // Rotas Antigas
                .route(p -> p.path("/currency-exchange/**")
                    .uri("lb://currency-exchange"))
                .route(p -> p.path("/currency-conversion/**")
                    .filters(f -> f.circuitBreaker(c ->
                        c.setName("circuitbreaker_conversion")
                        .setFallbackUri("forward:/fallback/currency-conversion")
                    ))
                    .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))
                
                // --- NOVAS ROTAS DO TRABALHO ---
                
                // Quando alguém chamar gateway:8765/quote... manda para o currency-report
                .route(p -> p.path("/quote/**")
                    .uri("lb://currency-report"))
                
                // Quando alguém chamar gateway:8765/history... manda para o currency-history
                .route(p -> p.path("/history/**")
                    .uri("lb://currency-history"))
                
                .build();
    }
}