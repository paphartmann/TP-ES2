package com.engsoft2.currencyreport;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest(properties = {
	"eureka.client.enabled=false",
	"spring.cloud.discovery.enabled=false",
	"spring.cloud.openfeign.enabled=false" // evita criar cliente Feign real nos testes
})
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
