package com.example.r2dbcpostgres;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.test.StepVerifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;

@SpringBootTest
@Testcontainers
class R2dbcPostgresApplicationTests {

	@Container
	@ServiceConnection
	static PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:15-alpine");

	@Autowired
	private ProfileRepository repository;

	@Test
	void contextLoads() {
		StepVerifier.create(this.repository.count())
			.expectNext(4L)
			.verifyComplete();
	}

}
