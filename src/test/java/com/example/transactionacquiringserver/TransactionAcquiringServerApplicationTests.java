package com.example.transactionacquiringserver;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.transactionacquiringserver.controllers.PaymentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionAcquiringServerApplicationTests {
	@Autowired
	private PaymentController controller;
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
