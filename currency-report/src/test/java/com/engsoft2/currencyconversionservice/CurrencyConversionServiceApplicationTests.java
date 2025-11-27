package com.engsoft2.currencyreport;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootTest(
	classes = {CurrencyReportApplication.class, CurrencyReportApplicationTests.StubConfig.class},
	properties = {
		"eureka.client.enabled=false",
		"eureka.client.register-with-eureka=false",
		"eureka.client.fetch-registry=false",
		"spring.cloud.discovery.enabled=false",
		"spring.cloud.openfeign.enabled=false" // evita criar cliente Feign real nos testes
	}
)
@ImportAutoConfiguration(exclude = FeignAutoConfiguration.class)
class CurrencyReportApplicationTests {

	@TestConfiguration
	static class StubConfig {
		@Bean
		CurrencyExchangeProxy currencyExchangeProxy() {
			return (from, to) -> {
				CurrencyExchangeDto dto = new CurrencyExchangeDto();
				dto.setFrom(from);
				dto.setTo(to);
				dto.setConversionMultiple(1.0);
				return dto;
			};
		}
	}

	@Test
	void contextLoads() {
		// sanity check: context must load without external infra
	}

}
