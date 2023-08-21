package com.example.r2dbcmariadb;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.test.StepVerifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;

@SpringBootTest
@Testcontainers
class R2dbcMariadbApplicationTests {

	@Container
	@ServiceConnection
	static MariaDBContainer<?> container = new MariaDBContainer<>("mariadb:11");

	@Autowired
	private ProfileRepository repository;

	@Test
	void contextLoads() {
		StepVerifier.create(this.repository.count())
				.expectNext(4L)
				.verifyComplete();
	}

}
