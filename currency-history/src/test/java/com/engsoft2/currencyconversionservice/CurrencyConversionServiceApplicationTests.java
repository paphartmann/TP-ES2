package com.engsoft2.currencyhistory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
	"eureka.client.enabled=false",
	"spring.cloud.discovery.enabled=false"
})
class CurrencyHistoryApplicationTests {

	@Test
	void contextLoads() {
		// sanity check: context must load without external infra
	}

}
