package com.engsoft2.currencyreport;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
	"eureka.client.enabled=false",
	"spring.cloud.discovery.enabled=false"
})
class CurrencyReportApplicationTests {

	@Test
	void contextLoads() {
		// sanity check: context must load without external infra
	}

}
